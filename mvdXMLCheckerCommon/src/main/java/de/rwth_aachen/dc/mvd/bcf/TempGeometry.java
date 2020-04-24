package de.rwth_aachen.dc.mvd.bcf;

import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point3d;
import javax.xml.parsers.ParserConfigurationException;

import org.opensource_bimserver.v1_40.geometry.Matrix;
import org.opensource_bimserver.v1_40.plugins.renderengine.RenderEngineException;
import org.opensource_bimserver.v1_40.plugins.renderengine.RenderEngineGeometry;
import org.opensource_bimserver.v1_40.plugins.renderengine.RenderEngineInstance;
import org.opensource_bimserver.v1_40.plugins.renderengine.RenderEngineModel;
import org.xml.sax.SAXException;

import nl.tue.ddss.bcf.BoundingBox;

// Modified ny JO, 22/04/2020 from the original 
// nl.tue.ddss.bcf.TempGeometry

public class TempGeometry {
    private final BoundingBox boundingBox;
    private double cameraViewPointX;
    private double cameraViewPointY;
    private double cameraViewPointZ;
    private double cameraUpVectorX;
    private double cameraUpVectorY;
    private double cameraUpVectorZ;
    private double cameraDirectionX;
    private double cameraDirectionY;
    private double cameraDirectionZ;

    public TempGeometry(RenderEngineModel renderEngineModel, long ifcProductExpressId) {
	this.boundingBox = getBoundingBox(renderEngineModel, ifcProductExpressId);
	if(boundingBox==null)
	{
	    System.err.println("Does not have a geometry");
	    return;
	}

	Point3d max = boundingBox.getMax();
	Point3d min = boundingBox.getMin();

	double centerX = (max.getX() + min.getX()) / 2;
	double centerY = (max.getY() + min.getY()) / 2;
	double centerZ = (max.getZ() + min.getZ()) / 2;
	double lengthX = max.getX() - min.getX();
	double lengthY = max.getY() - min.getY();
	double lengthZ = max.getZ() - min.getZ();

	double lengthMax = lengthX;
	if (lengthY > lengthMax)
	    lengthMax = lengthY;
	if (lengthZ > lengthMax)
	    lengthMax = lengthZ;

	cameraViewPointX = centerX + ((2 * lengthMax) * Math.cos(Math.PI / 4));
	cameraViewPointY = centerY + ((2 * lengthMax) * Math.cos(Math.PI / 4));
	cameraViewPointZ = centerZ + 0.5 * lengthMax;

	cameraDirectionX = centerX - cameraViewPointX;
	cameraDirectionY = centerY - cameraViewPointY;
	cameraDirectionZ = centerZ - cameraViewPointZ;

	cameraUpVectorX = cameraDirectionX;
	cameraUpVectorY = cameraDirectionY;
	cameraUpVectorZ = ((Math.pow(cameraDirectionX, 2) + Math.pow(cameraDirectionY, 2)) / -cameraDirectionZ);

    }

   
    private BoundingBox getBoundingBox(RenderEngineModel renderEngineModel, long ifcProductExpressId) {
	BoundingBox boundingBox=null;
	RenderEngineInstance renderEngineInstance;
	try {
	    renderEngineInstance = renderEngineModel.getInstanceFromExpressId((int)ifcProductExpressId); // new version uses long
	    System.out.println("RenderEngineInstance for "+ifcProductExpressId+" is "+renderEngineInstance);
	    if(renderEngineInstance==null)
	    {
		System.err.println("Not found rendering for: "+ifcProductExpressId);
		return null;
	    }
	    RenderEngineGeometry geometry = renderEngineInstance.generateGeometry();
	    if (geometry != null && geometry.getNrIndices() > 0) {
		boundingBox = new BoundingBox();
		float[] tranformationMatrix = new float[16];
		if (renderEngineInstance.getTransformationMatrix() != null) {
		    tranformationMatrix = renderEngineInstance.getTransformationMatrix();
		    tranformationMatrix = Matrix.changeOrientation(tranformationMatrix);
		} else {
		    Matrix.setIdentityM(tranformationMatrix, 0);
		}

		for (int i = 0; i < geometry.getIndices().length; i++) {
		    processExtends(boundingBox, tranformationMatrix, geometry.getVertices(), geometry.getIndices()[i] * 3);
		}
	    }
	} catch (RenderEngineException e) {
	    e.printStackTrace();
	}
	return boundingBox;
    }

    private void processExtends(BoundingBox boundingBox, float[] transformationMatrix, float[] vertices, int index) {
	float x = vertices[index];
	float y = vertices[index + 1];
	float z = vertices[index + 2];
	float[] result = new float[4];
	Matrix.multiplyMV(result, 0, transformationMatrix, 0, new float[] { x, y, z, 1 }, 0);
	x = result[0];
	y = result[1];
	z = result[2];
	Point3d point = new Point3d(x / 1000, y / 1000, z / 1000);
	boundingBox.add(point);
    }

    
    // Getters
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    
    public double getCameraViewPointX() {
        return cameraViewPointX;
    }

    public double getCameraViewPointY() {
        return cameraViewPointY;
    }

    public double getCameraViewPointZ() {
        return cameraViewPointZ;
    }

    public double getCameraUpVectorX() {
        return cameraUpVectorX;
    }

    public double getCameraUpVectorY() {
        return cameraUpVectorY;
    }

    public double getCameraUpVectorZ() {
        return cameraUpVectorZ;
    }

    public double getCameraDirectionX() {
        return cameraDirectionX;
    }

    public double getCameraDirectionY() {
        return cameraDirectionY;
    }

    public double getCameraDirectionZ() {
        return cameraDirectionZ;
    }

    
    
    
}
