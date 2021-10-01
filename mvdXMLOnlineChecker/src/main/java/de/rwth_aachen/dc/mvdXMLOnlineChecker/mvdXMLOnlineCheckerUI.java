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
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
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
import de.rwth_aachen.dc.mvd.events.CheckerBreakEvent;
import de.rwth_aachen.dc.mvd.events.CheckerElementApplicabilityNotificationEvent;
import de.rwth_aachen.dc.mvd.events.CheckerElementValidityNotificationEvent;
import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import de.rwth_aachen.dc.mvd.events.CheckerInfoEvent;
import de.rwth_aachen.dc.mvd.events.CheckerIssueEvent;
import de.rwth_aachen.dc.mvd.events.CheckerNotificationEvent;
import de.rwth_aachen.dc.mvd.events.CheckerShortNotificationEvent;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MvdXMLv1dot1Check;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MvdXMLv1dot2Check;
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

    private CheckBox showApplicability;
    private CheckBox showValidation;
    private CheckBox showIssues;
    private CheckBox showExtraInfo;
    private Button check_button;

    // Create a rich text area
    final RichTextArea reasoning_area = new RichTextArea();
    final StringBuilder reasoning = new StringBuilder();
    
    Image image;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
	final VerticalLayout layout = new VerticalLayout();
	Resource res = new ThemeResource("rwth_caad_en_schwarz_grau_rgb.svg");
	this.image = new Image("",res);
	this.image.setHeight("200px");
        this.image.setHeight("100px");
	layout.addComponent(this.image);
	final Label labelH1 = new Label("mvdXML Online Checker");
	labelH1.addStyleName(ValoTheme.LABEL_H1);
	layout.addComponent(labelH1);

	final Label instruction_label = new Label("Currently supported versions are mvdXML V1-1, V1.1 and  V1.2 draft3.");
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
	issues_grid.addColumn(IssueBean::getMvdXMLConcept).setCaption("Concept");
	issues_grid.addColumn(IssueBean::getIfcClassName).setCaption("Element type");
	issues_grid.addColumn(IssueBean::getName).setCaption("Name");
	issues_grid.addColumn(IssueBean::getGuid).setCaption("Guid");
	// issues_grid.addColumn(Issue::getComment).setCaption("Comment");
	issues_grid.addComponentColumn(item -> createCommentPopUpButton(item)).setCaption("Comment");
	issues_grid.setWidth("100%");
	layout.addComponent(issues_grid);

	HorizontalLayout button_layout2 = new HorizontalLayout();
	this.save_as_bcfzip_button = new Button("Save the result as BCF Zip");
	this.save_as_bcfzip_button.setEnabled(false);

	button_layout2.addComponent(save_as_bcfzip_button);
	showApplicability = new CheckBox();
	showApplicability.setCaption("Show reasoning for element applicability.");
	showApplicability.setValue(true);
	showApplicability.addValueChangeListener(x->{
	    checkIFCFile();
	});
	button_layout2.addComponent(showApplicability);

	showValidation = new CheckBox();
	showValidation.setCaption("Show reasoning for element validation.");
	showValidation.setValue(false);
	showValidation.addValueChangeListener(x->{
	    checkIFCFile();
	});
	button_layout2.addComponent(showValidation);

	showIssues = new CheckBox();
	showIssues.setCaption("Show issues.");
	showIssues.setValue(true);
	showIssues.addValueChangeListener(x->{
	    checkIFCFile();
	});
	button_layout2.addComponent(showIssues);

	showExtraInfo = new CheckBox();
	showExtraInfo.setCaption("Show extra info.");
	showExtraInfo.setValue(false);
	showIssues.addValueChangeListener(x->{
	    checkIFCFile();
	});
	button_layout2.addComponent(showExtraInfo);
	layout.addComponent(button_layout2);

	reasoning_area.setCaption("Reasoning for the results");
	reasoning_area.setWidth("100%");
	// reasoning_area.setHeight("70px");;
	reasoning_area.setReadOnly(true);
	layout.addComponent(reasoning_area);

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
	reasoning.setLength(0); // clean the content
	reasoning_area.clear();
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

	    } else
	    // mvdXML 1.2
	    if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(this.mvdXMLFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvd/XML/1.2")) {
		Notification n = new Notification("mvdXML 1.1.", Notification.Type.TRAY_NOTIFICATION);
		n.setDelayMsec(5000);
		n.show(Page.getCurrent());
		IssueReport issuereport = MvdXMLv1dot2Check.check(this.ifcFile.toPath(), this.mvdXMLFile.getAbsolutePath());
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

    @Subscribe
    public void infoEvent(CheckerInfoEvent event) {
	if (this.showExtraInfo.getValue()) {
	    reasoning.append(event.getTopic() + ": " + event.getValue() + "<BR>");
	    reasoning_area.setValue(reasoning.toString());
	}
    }

    @Subscribe
    public void errorEvent(CheckerErrorEvent event) {
	reasoning.append("Issue: " + event.getClass_name() + ": " + event.getMessage() + "<BR>");
	reasoning_area.setValue(reasoning.toString());
    }

    @Subscribe
    public void notificationEvent(CheckerElementApplicabilityNotificationEvent event) {
	if (this.showApplicability.getValue()) {
	    reasoning.append(" " + event.getValue() + "<BR>");
	    reasoning_area.setValue(reasoning.toString());
	}
    }

    @Subscribe
    public void notificationEvent(CheckerElementValidityNotificationEvent event) {
	if (this.showValidation.getValue()) {
	    reasoning.append(" " + event.getValue() + "<BR>");
	    reasoning_area.setValue(reasoning.toString());
	}
    }

    @Subscribe
    public void notificationEvent(CheckerIssueEvent event) {
	if (this.showIssues.getValue()) {
	    reasoning.append(" " + event.getValue() + "<BR>");
	    reasoning_area.setValue(reasoning.toString());
	}
    }

    @Subscribe
    public void notificationEvent(CheckerNotificationEvent event) {
	reasoning.append(" " + event.getValue() + "<BR>");
	reasoning_area.setValue(reasoning.toString());
    }

    @Subscribe
    public void notificationEvent(CheckerShortNotificationEvent event) {
	reasoning.append(" " + event.getValue() + " ");
	reasoning_area.setValue(reasoning.toString());
    }

    @Subscribe
    public void breakEvent(CheckerBreakEvent event) {
	reasoning.append("<HR>");
	reasoning_area.setValue(reasoning.toString());
    }

    @WebServlet(urlPatterns = "/*", name = "mvdXMLOnlineCheckerUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = mvdXMLOnlineCheckerUI.class, productionMode = false)
    public static class mvdXMLOnlineCheckerUIServlet extends VaadinServlet {
    }
}
