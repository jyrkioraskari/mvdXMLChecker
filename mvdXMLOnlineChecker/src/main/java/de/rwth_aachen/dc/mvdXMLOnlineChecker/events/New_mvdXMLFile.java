package de.rwth_aachen.dc.mvdXMLOnlineChecker.events;

import java.util.List;

import nl.tue.ddss.mvdparser.MVDConstraint;
import nl.tue.ddss.mvdparser.MvdXMLParser;

public class New_mvdXMLFile {
    private final  List<MVDConstraint> constraints;    
    private final String filename;

    public New_mvdXMLFile(List<MVDConstraint> constraints, String filename) {
	super();
	this.constraints=constraints;
	this.filename = filename;
    }
    
    
    public List<MVDConstraint> getConstraints() {
        return constraints;
    }

    public String getFilename() {
        return filename;
    }
}
