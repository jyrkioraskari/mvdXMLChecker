package de.rwth_aachen.dc.mvd.beans;

public class IssueBean {
    private String ifcSpatialStructureElement=null;
    private String ifcClassName;
    private String guid;
    private String name;
    private String comment;

    
    public IssueBean() {
	super();
    }

    public IssueBean(String ifcSpatialStructureElement, String ifcClassName,String guid, String name, String comment) {
	super();
	this.ifcSpatialStructureElement = ifcSpatialStructureElement;
	this.ifcClassName = ifcClassName;
	this.guid = guid;
	this.name = name;
	this.comment = comment;
    }

    public IssueBean(String ifcClassName,String guid, String name, String comment) {
 	super();
 	this.ifcClassName = ifcClassName;
 	this.guid = guid;
 	this.name = name;
 	this.comment = comment;
     }

    public String getIfcSpatialStructureElement() {
	return ifcSpatialStructureElement;
    }

     public String getIfcClassName() {
        return ifcClassName;
    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
	return comment;
    }

    public void setIfcSpatialStructureElement(String ifcSpatialStructureElement) {
        this.ifcSpatialStructureElement = ifcSpatialStructureElement;
    }

    public void setIfcClassName(String ifcClassName) {
        this.ifcClassName = ifcClassName;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
}
