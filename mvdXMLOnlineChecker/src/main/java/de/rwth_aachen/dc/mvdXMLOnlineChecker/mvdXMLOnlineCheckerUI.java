package de.rwth_aachen.dc.mvdXMLOnlineChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;

import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
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

import de.rwth_aachen.dc.mvd.beans.Issue;
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
    private Label ifcXMLFileLabel = new Label("IFC STEP file");
    private File mvdXMLFile = null;
    private File ifcXMLFile = null;

    private Grid<Issue> issues_grid = new Grid<>();
    private List<Issue> issues = new ArrayList<>();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
	final VerticalLayout layout = new VerticalLayout();
	final Label labelH1 = new Label("mvdXML Online Checker");
	labelH1.addStyleName(ValoTheme.LABEL_H1);
	layout.addComponent(labelH1);

	final Label instruction_label = new Label("Currently supported versions are: IFC2X3 for mvdXML1-1, and IFC2x3 and IFC4 for mvdXML 1.1.");
	layout.addComponent(instruction_label);

	layout.addComponents(mvdXMLFileLabel, ifcXMLFileLabel);

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

	Button check_button = new Button("Check");
	check_button.addClickListener(x -> {
	    checkIFCFile();
	});
	HorizontalLayout button_layout = new HorizontalLayout();
	button_layout.addComponents(file_uploader, check_button);
	button_layout.setComponentAlignment(file_uploader, Alignment.BOTTOM_CENTER);
	button_layout.setComponentAlignment(check_button, Alignment.BOTTOM_CENTER);

	layout.addComponent(button_layout);

	issues_grid.setItems(issues);
	issues_grid.addColumn(Issue::getIfcClassName).setCaption("Element type");
	issues_grid.addColumn(Issue::getName).setCaption("Name");
	issues_grid.addColumn(Issue::getGuid).setCaption("Guid");
	// issues_grid.addColumn(Issue::getComment).setCaption("Comment");
	issues_grid.addComponentColumn(item -> createCommentPopUpButton(item)).setCaption("Comment");
	issues_grid.setWidth("100%");
	layout.addComponent(issues_grid);

	setContent(layout);
	communication.register(this);
    }

    private Button createCommentPopUpButton(Issue item) {
	@SuppressWarnings("unchecked")
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
	if (this.ifcXMLFile == null) {
	    Notification n = new Notification("Upload an IFC file.", Notification.Type.TRAY_NOTIFICATION);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return;
	}
	if (this.mvdXMLFile == null) {
	    Notification n = new Notification("Upload an mvdXML file.", Notification.Type.TRAY_NOTIFICATION);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return;
	}
	try {

	    if (checkMvdXMLSchemaVersion(this.ifcXMLFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvd/XML/1.1")) {
		List<Issue> result = MvdXMLv1dot1Check.check(this.ifcXMLFile.toPath(), this.ifcXMLFile.getAbsolutePath());
		issues.addAll(result);

	    } else {
		// mvdXML 1_1
		if (checkMvdXMLSchemaVersion(this.ifcXMLFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvdXML/mvdXML1-1")) {
		    List<Issue> result = MvdXMLv1undescore1Check.check(this.ifcXMLFile.toPath(), this.ifcXMLFile.getAbsolutePath());
		    issues.addAll(result);
		}
	    }

	    // issues.addAll(report.getIssues());
	    issues_grid.setItems(issues);
	} catch (Exception e) {
	    // TODO: handle exception
	}
    }

    private boolean checkMvdXMLSchemaVersion(String filename, String schemaName) {
	try {
	    File myObj = new File(filename);
	    Scanner myReader = new Scanner(myObj);
	    for (int i = 0; i < 5; i++)
		if (myReader.hasNextLine())
		    if (checSchemaLine(myReader.nextLine(), schemaName))
			return true;

	    myReader.close();
	} catch (FileNotFoundException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	}
	return false;
    }

    private boolean checSchemaLine(String line, String schemaName) {
	String[] tokens = line.split("[ =>]");
	for (String t : tokens) {
	    if (t.equals("\"" + schemaName + "\""))
		return true;
	}
	return false;
    }

    @Subscribe
    public void onNew_ifcSTEPFile(New_ifcSTEPFile event) {
	this.ifcXMLFileLabel.setValue("IFC: " + event.getFile().getName());
	this.ifcXMLFile = event.getFile();
    }

    @Subscribe
    public void onNew_mvdXMLFile(New_mvdXMLFile event) {
	this.mvdXMLFileLabel.setValue("mvdXML: " + event.getFile().getName());
	this.mvdXMLFile = event.getFile();
    }

    @WebServlet(urlPatterns = "/*", name = "mvdXMLOnlineCheckerUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = mvdXMLOnlineCheckerUI.class, productionMode = false)
    public static class mvdXMLOnlineCheckerUIServlet extends VaadinServlet {
    }
}
