package de.rwth_aachen.dc.mvdXMLOnlineChecker.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

import de.rwth_aachen.dc.mvdXMLOnlineChecker.events.New_ifcSTEPFile;
import de.rwth_aachen.dc.mvdXMLOnlineChecker.events.New_mvdXMLFile;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;

public class WebFileHandler implements Receiver, SucceededListener, FailedListener {
    private EventBusCommunication communication = EventBusCommunication.getInstance();

    private static final long serialVersionUID = -3353293504543369792L;
    public File file;
    private String uploads;

    public WebFileHandler(String uploads) {
	this.uploads = uploads;
	if (!uploads.endsWith(File.separator))
	    this.uploads = this.uploads + File.separator;
    }

    public OutputStream receiveUpload(String filename, String mimeType) {
	file = null;
	if ((filename == null) || filename.length() == 0) {
	    Notification n = new Notification("A file has to be selected", " ", Notification.Type.ERROR_MESSAGE);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return null;
	}
	if (!(filename.toLowerCase().endsWith(".ifc") || filename.toLowerCase().endsWith(".mvdxml") || filename.toLowerCase().endsWith(".xml"))) {
	    Notification n = new Notification("The file extension has to be .ifc, .xml, or .mvdxml", " ", Notification.Type.ERROR_MESSAGE);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return null;

	}

	// Create upload stream
	FileOutputStream fos = null; // Stream to write to
	try {
	    // Open the file for writing.
	    file = new File(uploads + filename);
	    fos = new FileOutputStream(file);
	} catch (final java.io.FileNotFoundException e) {
	    Notification n = new Notification("Could not open file ", e.getMessage(), Notification.Type.ERROR_MESSAGE);
	    n.setDelayMsec(5000);
	    n.show(Page.getCurrent());
	    return null;
	}
	return fos; 
    }
    
    public void uploadSucceeded(SucceededEvent event) {
	Notification n = new Notification("Uploading succeed.", Notification.Type.TRAY_NOTIFICATION);
	n.setDelayMsec(1000);
	n.show(Page.getCurrent());
	
	if (event.getFilename().toLowerCase().endsWith(".ifc")) {
		communication.post(new New_ifcSTEPFile(this.file.getAbsolutePath(),event.getFilename()));
	}
	if (event.getFilename().toLowerCase().endsWith(".mvdxml") || event.getFilename().toLowerCase().endsWith(".xml")) {
		communication.post(new New_mvdXMLFile(this.file.getAbsolutePath(),event.getFilename()));
	}

    }
    
    @Override
    public void uploadFailed(FailedEvent event) {
	Notification n = new Notification("Uploading the file failed.", Notification.Type.ERROR_MESSAGE);
	n.setDelayMsec(1000);
	n.show(Page.getCurrent());
    }
};
