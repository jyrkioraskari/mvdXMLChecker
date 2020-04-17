package de.rwth_aachen.dc.mvdXMLOnlineChecker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.serializers.SerializerException;
import org.xml.sax.SAXException;

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

import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.Issue;
import de.rwth_aachen.dc.mvdXMLOnlineChecker.events.New_ifcSTEPFile;
import de.rwth_aachen.dc.mvdXMLOnlineChecker.events.New_mvdXMLFile;
import de.rwth_aachen.dc.mvdXMLOnlineChecker.upload.WebFileHandler;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import nl.tue.ddss.ifc_check.IfcMVDConstraintChecker;
import nl.tue.ddss.mvdparser.MVDConstraint;

@Theme("rwth")
public class mvdXMLOnlineCheckerUI extends UI {
    private EventBusCommunication communication = EventBusCommunication.getInstance();

    private List<MVDConstraint> constraints = null;
    private IfcModelInterface ifcModel = null;
    private Label mvdXMLFileLabel = new Label("mvdXML file");
    private Label ifcXMLFileLabel = new Label("IFC STEP file");
    private Grid<Issue> issues_grid = new Grid<>();
    private List<Issue> issues = new ArrayList<>();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
	final VerticalLayout layout = new VerticalLayout();
	final Label labelH1 = new Label("mvdXML Online Checker");
	labelH1.addStyleName(ValoTheme.LABEL_H1);
	layout.addComponent(labelH1);

	final Label instruction_label = new Label("Currently supported versions are: IFC2X3 and mvdXML1-1 (not yet 1.1).");
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
	if (this.ifcModel == null) {
	    Notification n = new Notification("Upload an IFC file.", Notification.Type.TRAY_NOTIFICATION);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return;
	}
	if (this.constraints == null) {
	    Notification n = new Notification("Upload an mvdXML file.", Notification.Type.TRAY_NOTIFICATION);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return;
	}
	try {
	    IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints);
	    IssueReport report = ifcChecker.checkModel(ifcModel);
	    if (report.getIssues().isEmpty()) {
		Notification n = new Notification("No issues.", Notification.Type.TRAY_NOTIFICATION);
		n.setDelayMsec(5000);
		n.show(Page.getCurrent());
		return;
	    }
	    issues.addAll(report.getIssues());
	    issues_grid.setItems(issues);
	} catch (JAXBException e) {
	    e.printStackTrace();
	} catch (DeserializeException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (URISyntaxException e) {
	    e.printStackTrace();
	} catch (RenderEngineException e) {
	    e.printStackTrace();
	} catch (ParserConfigurationException e) {
	    e.printStackTrace();
	} catch (SAXException e) {
	    e.printStackTrace();
	} catch (SerializerException e) {
	    e.printStackTrace();
	}

    }

    @Subscribe
    public void onNew_ifcSTEPFile(New_ifcSTEPFile event) {
	ifcXMLFileLabel.setValue("IFC: " + event.getFilename());
	this.ifcModel = event.getIfcModel();
    }

    @Subscribe
    public void onNew_mvdXMLFile(New_mvdXMLFile event) {
	mvdXMLFileLabel.setValue("mvdXML: " + event.getFilename());
	this.constraints = event.getConstraints();
    }

    @WebServlet(urlPatterns = "/*", name = "mvdXMLOnlineCheckerUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = mvdXMLOnlineCheckerUI.class, productionMode = false)
    public static class mvdXMLOnlineCheckerUIServlet extends VaadinServlet {
    }
}
