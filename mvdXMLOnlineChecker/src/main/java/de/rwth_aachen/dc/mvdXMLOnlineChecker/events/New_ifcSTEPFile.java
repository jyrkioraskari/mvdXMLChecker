package de.rwth_aachen.dc.mvdXMLOnlineChecker.events;

import java.io.File;

public class New_ifcSTEPFile {
    private final File file;
    

    public New_ifcSTEPFile(File file) {
	super();
	this.file = file;
    }
    
    public File getFile() {
        return this.file;
    }
}
