package de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans;

import java.util.ArrayList;
import java.util.List;

import de.rwth_aachen.dc.mvd.ifcvalidator.db.MvdXMLFileHandle;

public class MvdXMLFileHandleList extends ResponseBean{
    List<MvdXMLFileHandle> files = new ArrayList<>();

    public MvdXMLFileHandleList () {
	super();
    }
    
    public List<MvdXMLFileHandle> getFiles() {
        return files;
    }

    public void setFiles(List<MvdXMLFileHandle> files) {
        this.files = files;
    }

    public void append(MvdXMLFileHandle file)
    {
	this.files.add(file);
    }
}
