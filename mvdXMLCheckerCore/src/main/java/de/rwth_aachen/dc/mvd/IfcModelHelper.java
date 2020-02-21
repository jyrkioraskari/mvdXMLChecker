package de.rwth_aachen.dc.mvd;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.ifc.step.deserializer.Ifc2x3tc1StepDeserializer;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.utils.DeserializerUtils;

@SuppressWarnings("deprecation")
public class IfcModelHelper {
    
    static public IfcModelInterface readModel(Path ifcFilePath,Path ifcShcemaDirectory) {
	Deserializer deserializer = new Ifc2x3tc1StepDeserializer();	
	PackageMetaData pmd=new PackageMetaData(Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1,ifcShcemaDirectory);
	deserializer.init(pmd);
	try {
		return DeserializerUtils.readFromFile(deserializer, ifcFilePath);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
    }
    
 
    public static void main(String[] args) {
	IfcModelInterface ifcmodel=IfcModelHelper.readModel(Paths.get("c:\\ifc\\Duplex_A_20110505.ifc"),Paths.get("."));
    }
}
