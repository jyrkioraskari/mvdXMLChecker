package de.rwth_aachen.dc.mvdXMLOnlineChecker.events;

import org.bimserver.emf.IfcModelInterface;

public class New_ifcSTEPFile {
    private final IfcModelInterface ifcModel;    
    private final String filename;
    

    public New_ifcSTEPFile(IfcModelInterface ifcModel,String filename) {
	super();
	this.ifcModel=ifcModel;
	this.filename = filename;
    }
    

    public IfcModelInterface getIfcModel() {
        return ifcModel;
    }


    public String getFilename() {
        return filename;
    }
}
