package de.rwth_aachen.dc.mvdXMLOnlineChecker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.MvdXMLVersionCheck;
import de.rwth_aachen.dc.mvd.beans.IssueBean;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MvdXMLv1dot1Check;
import de.rwth_aachen.dc.mvd.mvdxml1underscore1.checker.MvdXMLv1undescore1Check;
import de.rwth_aachen.dc.mvdXMLOnlineChecker.events.New_ifcSTEPFile;
import de.rwth_aachen.dc.mvdXMLOnlineChecker.events.New_mvdXMLFile;
import de.rwth_aachen.dc.mvdXMLOnlineChecker.upload.WebFileHandler;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;

@Theme("rwth")
public class mvdXMLOnlineCheckerUI extends UI {
    private EventBusCommunication communication = EventBusCommunication.getInstance();

    private Label mvdXMLFileLabel = new Label("mvdXML file");
    private Label ifcFileLabel = new Label("IFC STEP file");
    private File mvdXMLFile = null;
    private File ifcFile = null;

    private Grid<IssueBean> issues_grid = new Grid<>();
    private List<IssueBean> issues = new ArrayList<>();

    private Button save_as_bcfzip_button;
    private FileDownloader fileDownloader;

    private Button check_button;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
	final VerticalLayout layout = new VerticalLayout();
	final Label labelH1 = new Label("mvdXML Online Checker");
	labelH1.addStyleName(ValoTheme.LABEL_H1);
	layout.addComponent(labelH1);

	final Label instruction_label = new Label("Currently supported versions are mvdXML1-1 and mvdXML 1.1.");
	layout.addComponent(instruction_label);

	layout.addComponents(mvdXMLFileLabel, ifcFileLabel);

	WebFileHandler file_receiver = null;
	try {
	    Path tempdirectory = Files.createTempDirectory("mvdXMLCheckerOnline");
	    file_receiver = new WebFileHandler(tempdirectory.toString());
	} catch (IOException e) {
	    e.printStackTrace();
	}
	if (file_receiver == null)
	    return; // Cannot throw an exception

	Upload file_uploader = new Upload("Upload the ifc/mvsXML file here", file_receiver);
	file_uploader.addSucceededListener(file_receiver);
	file_uploader.addFailedListener(file_receiver);
	file_uploader.setButtonCaption("Upload file");
	file_uploader.setImmediateMode(true);

	this.check_button = new Button("Check");
	this.check_button.setEnabled(false);
	this.check_button.addClickListener(x -> {
	    checkIFCFile();
	});
	HorizontalLayout button_layout = new HorizontalLayout();
	button_layout.addComponents(file_uploader, this.check_button);
	button_layout.setComponentAlignment(file_uploader, Alignment.BOTTOM_CENTER);
	button_layout.setComponentAlignment(check_button, Alignment.BOTTOM_CENTER);

	layout.addComponent(button_layout);

	issues_grid.setItems(issues);
	issues_grid.addColumn(IssueBean::getIfcClassName).setCaption("Element type");
	issues_grid.addColumn(IssueBean::getName).setCaption("Name");
	issues_grid.addColumn(IssueBean::getGuid).setCaption("Guid");
	// issues_grid.addColumn(Issue::getComment).setCaption("Comment");
	issues_grid.addComponentColumn(item -> createCommentPopUpButton(item)).setCaption("Comment");
	issues_grid.setWidth("100%");
	layout.addComponent(issues_grid);

	this.save_as_bcfzip_button = new Button("Save the result as BCF Zip");
	this.save_as_bcfzip_button.setEnabled(false);

	layout.addComponent(save_as_bcfzip_button);

	setContent(layout);
	communication.register(this);
    }

    private Button createCommentPopUpButton(IssueBean item) {
	Button button = new Button("Show", clickEvent -> {
	    // Create a sub-window and set the content
	    Window subWindow = new Window("Comment descriptor");
	    VerticalLayout subContent = new VerticalLayout();
	    subWindow.setContent(subContent);
	    subWindow.setHeight("450px");
	    subWindow.setWidth("700px");
	    RichTextArea richtext = new RichTextArea();
	    richtext.setSizeFull();
	    richtext.setValue(item.getComment());
	    subContent.addComponent(richtext);

	    subWindow.center();
	    addWindow(subWindow);
	});
	return button;
    }

    public void checkIFCFile() {
	issues.clear();
	
	try {

	    // mvdXML 1.1
	    if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(this.mvdXMLFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvd/XML/1.1")) {
		Notification n = new Notification("mvdXML 1.1.", Notification.Type.TRAY_NOTIFICATION);
		n.setDelayMsec(5000);
		n.show(Page.getCurrent());
		IssueReport issuereport = MvdXMLv1dot1Check.check(this.ifcFile.toPath(), this.mvdXMLFile.getAbsolutePath());
		issues.addAll(issuereport.getIssues());

		File tempBCFZipFile = File.createTempFile("mvdXMLCheckResult", ".bcfzip");
		tempBCFZipFile.deleteOnExit();
		issuereport.writeReport(tempBCFZipFile.getAbsolutePath().toString());

		Resource res = new FileResource(tempBCFZipFile);
		if (this.fileDownloader == null) {
		    this.fileDownloader = new FileDownloader(res);
		    this.fileDownloader.extend(this.save_as_bcfzip_button);
		} else {
		    this.fileDownloader.setFileDownloadResource(res);
		}
		this.save_as_bcfzip_button.setEnabled(true);

	    } else {
		// mvdXML 1_1
		if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(this.mvdXMLFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvdXML/mvdXML1-1")) {
		    Notification n = new Notification("mvdXML 1_1.", Notification.Type.TRAY_NOTIFICATION);
		    n.setDelayMsec(5000);
		    n.show(Page.getCurrent());
		    IssueReport issuereport = MvdXMLv1undescore1Check.check(this.ifcFile.toPath(), this.mvdXMLFile.getAbsolutePath());
		    issues.addAll(issuereport.getIssues());

		    File tempBCFZipFile = File.createTempFile("mvdXMLCheckResult", ".bcfzip");
		    tempBCFZipFile.deleteOnExit();
		    issuereport.writeReport(tempBCFZipFile.getAbsolutePath().toString());
		    Resource res = new FileResource(tempBCFZipFile);
		    if (this.fileDownloader == null) {
			this.fileDownloader = new FileDownloader(res);
			this.fileDownloader.extend(this.save_as_bcfzip_button);
		    } else {
			this.fileDownloader.setFileDownloadResource(res);
		    }
		    this.save_as_bcfzip_button.setEnabled(true);

		} else {
		    Notification n = new Notification("Unknown mvdXML version.", Notification.Type.TRAY_NOTIFICATION);
		    n.setDelayMsec(5000);
		    n.show(Page.getCurrent());

		}
	    }
	    issues_grid.setItems(issues);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Subscribe
    public void onNew_ifcSTEPFile(New_ifcSTEPFile event) {
	this.ifcFileLabel.setValue("IFC: " + event.getFile().getName());
	this.ifcFile = event.getFile();

	if (this.ifcFile != null && this.mvdXMLFile != null) {
	    this.check_button.setEnabled(true);
	}
	if (this.mvdXMLFile == null) {
	    Notification n = new Notification("Upload an mvdXML file.", Notification.Type.TRAY_NOTIFICATION);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return;
	}
    }

    @Subscribe
    public void onNew_mvdXMLFile(New_mvdXMLFile event) {
	this.mvdXMLFileLabel.setValue("mvdXML: " + event.getFile().getName());
	this.mvdXMLFile = event.getFile();

	if (this.ifcFile != null && this.mvdXMLFile != null) {
	    this.check_button.setEnabled(true);
	}
	if (this.ifcFile == null) {
	    Notification n = new Notification("Upload an IFC file.", Notification.Type.TRAY_NOTIFICATION);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return;
	}
    }

    @WebServlet(urlPatterns = "/*", name = "mvdXMLOnlineCheckerUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = mvdXMLOnlineCheckerUI.class, productionMode = false)
    public static class mvdXMLOnlineCheckerUIServlet extends VaadinServlet {
    }
}
