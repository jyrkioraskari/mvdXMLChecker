package de.rwth_aachen.dc.mvdXMLOnlineChecker.events;

public class New_mvdXMLFile {
    private final String absolute_filename;    
    private final String filename;

    public New_mvdXMLFile(String absolute_filename, String filename) {
	super();
	this.absolute_filename=absolute_filename;
	this.filename = filename;
    }
    
    

    public String getAbsolute_filename() {
        return absolute_filename;
    }

    public String getFilename() {
        return filename;
    }
}
