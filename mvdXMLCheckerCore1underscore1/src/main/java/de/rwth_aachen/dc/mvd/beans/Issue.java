package de.rwth_aachen.dc.mvd.beans;

import org.bimserver.models.ifc2x3tc1.IfcRoot;

public class Issue {
    private final String ifcSpatialStructureElement;
    private final String ifcClassName;
    private final String guid;
    private final String name;
    private final String comment;

    public Issue(String ifcSpatialStructureElement, String ifcClassName,String guid, String name, String comment) {
	super();
	this.ifcSpatialStructureElement = ifcSpatialStructureElement;
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

}
