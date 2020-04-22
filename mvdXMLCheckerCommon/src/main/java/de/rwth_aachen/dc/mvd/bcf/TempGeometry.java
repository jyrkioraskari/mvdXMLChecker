package de.rwth_aachen.dc.mvd.bcf;

import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point3d;
import javax.xml.parsers.ParserConfigurationException;

import org.openbimserver.geometry.Matrix;
import org.openbimserver.plugins.renderengine.RenderEngineException;
import org.openbimserver.plugins.renderengine.RenderEngineGeometry;
import org.openbimserver.plugins.renderengine.RenderEngineInstance;
import org.openbimserver.plugins.renderengine.RenderEngineModel;
import org.xml.sax.SAXException;

import nl.tue.ddss.bcf.BoundingBox;

// Modified ny JO, 22/04/2020 from the original 
// nl.tue.ddss.bcf.TempGeometry

public class TempGeometry {
    private BoundingBox boundingBox;
    private final ArrayList<String> stringList = new ArrayList<String>();
    private final ArrayList<Float> floatList = new ArrayList<Float>();
    private final ArrayList<Float> xList = new ArrayList<Float>();
    private final ArrayList<Float> yList = new ArrayList<Float>();
    private final ArrayList<Float> zList = new ArrayList<Float>();
    private double cameraViewPointX;
    private double cameraViewPointY;
    private double cameraViewPointZ;
    private double cameraUpVectorX;
    private double cameraUpVectorY;
    private double cameraUpVectorZ;
    private double cameraDirectionX;
    private double cameraDirectionY;
    private double cameraDirectionZ;

    public void setUpCamera(RenderEngineModel renderEngineModel, int ifcProductExpressId) throws SAXException, ParserConfigurationException {
	boundingBox = getBoundingBox(boundingBox, renderEngineModel, ifcProductExpressId);

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

    public BoundingBox getBoundingBox(BoundingBox boundingBox, RenderEngineModel renderEngineModel, List<Integer> ifcProductsExpressIds) {
	if (ifcProductsExpressIds != null && ifcProductsExpressIds.size() > 0) {
	    for (Integer ifcProductExpressId : ifcProductsExpressIds) {
		getBoundingBox(boundingBox, renderEngineModel, ifcProductExpressId);
	    }
	}
	return boundingBox;
    }

    private BoundingBox getBoundingBox(BoundingBox boundingBox, RenderEngineModel renderEngineModel, int ifcProductExpressId) {
	RenderEngineInstance renderEngineInstance;
	try {
	    renderEngineInstance = renderEngineModel.getInstanceFromExpressId(ifcProductExpressId);
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

}
