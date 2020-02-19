package de.rwth_aachen.dc.mvd.ifcvalidator.rest;

import javax.servlet.http.HttpServletResponse;

public class IfcCheckRequest {
   
    
    private String byte64CodedIfcSTEPFile="";
    private String byte64CodedMVDXML="";
    
    public String getByte64CodedIfcSTEPFile() {
        return byte64CodedIfcSTEPFile;
    }
    
    /**
     *  The IFC STEP formatted file to be tested. The file is encoded in Base64 encoding.
     *  The supported IFC version is 2x3.
     * @param byte64CodedIfcSTEPFile The IFC STEP formatted file to be tested.
     */
    public void setByte64CodedIfcSTEPFile(String byte64CodedIfcSTEPFile) {
        this.byte64CodedIfcSTEPFile = byte64CodedIfcSTEPFile;
    }

    public String getByte64CodedMVDXML() {
        return byte64CodedMVDXML;
    }
    
    /**
     *       * @param byte64CodedMVDXML The mvdXML definition file for the test.
     */
    public void setByte64CodedMVDXML(String byte64CodedMVDXML) {
        this.byte64CodedMVDXML = byte64CodedMVDXML;
    }


}
