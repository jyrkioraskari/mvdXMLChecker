package de.rwth_aachen.dc.mvd.mvdxml1dot1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.ifc.step.deserializer.Ifc2x3tc1StepDeserializer;
import org.bimserver.ifc.step.deserializer.Ifc4StepDeserializer;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.utils.DeserializerUtils;

@SuppressWarnings("deprecation")
public class IfcModelInstance {
    
    public enum IfcVersion {
	  IFC2x3,
	  IFC4,
	  UNKNOWN
	}
    private Optional<IfcVersion> ifcversion=Optional.empty();
    

    public IfcModelInterface readModel(Path ifcFilePath, Path ifcShcemaDirectory) {
	if (ifcFilePath.toFile().exists() && ifcFilePath.toFile().isFile()) {
	    switch (getExpressSchema(ifcFilePath.toString())) {
	    case IFC2x3:
		ifcversion=Optional.of(IfcModelInstance.IfcVersion.IFC2x3);
		Deserializer deserializer2x3 = new Ifc2x3tc1StepDeserializer();
		PackageMetaData pmd2x3 = new PackageMetaData(Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1, ifcShcemaDirectory);
		deserializer2x3.init(pmd2x3);
		try {
		    return DeserializerUtils.readFromFile(deserializer2x3, ifcFilePath);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		break;
	    case IFC4:
		ifcversion=Optional.of(IfcModelInstance.IfcVersion.IFC4);
		Deserializer deserializer4 = new Ifc4StepDeserializer(Schema.IFC4);
		PackageMetaData pmd4 = new PackageMetaData(Ifc4Package.eINSTANCE, Schema.IFC4, ifcShcemaDirectory);
		deserializer4.init(pmd4);
		try {
		    return DeserializerUtils.readFromFile(deserializer4, ifcFilePath);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		break;
	    default:
		return null;
	    }
	}
	return null;
    }

    public IfcVersion getExpressSchema(String ifc_file) {
	try {
	    FileInputStream fstream = new FileInputStream(ifc_file);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    try {
		String strLine;
		while ((strLine = br.readLine()) != null) {
		    if (strLine.length() > 0) {
			if (strLine.startsWith("FILE_SCHEMA")) {
			    if (strLine.indexOf("IFC2X3") != -1)
				return IfcModelInstance.IfcVersion.IFC2x3;
			    if (strLine.indexOf("IFC4") != -1)
				return IfcModelInstance.IfcVersion.IFC4;
			    else
				return IfcModelInstance.IfcVersion.UNKNOWN;
			}
		    }
		}
	    } finally {
		br.close();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return IfcModelInstance.IfcVersion.UNKNOWN;
    }
    
    

    public Optional<IfcVersion> getIfcversion() {
        return ifcversion;
    }
    
    public static void main(String[] args) {
	IfcModelInstance model=new IfcModelInstance();
	// IFC2x3
	//IfcModelInterface ifcmodel2x3 = model.readModel(Paths.get("c:\\ifc\\Duplex_A_20110505.ifc"), Paths.get("."));

	// IFC4
	IfcModelInterface ifcmodel4 =model.readModel(Paths.get("c:\\ifc\\20160125Autodesk_Hospital_Parking Garage_2015 - IFC4.ifc"), Paths.get("."));
	System.out.println(ifcmodel4.size());
    }
}
