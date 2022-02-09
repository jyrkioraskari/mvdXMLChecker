package de.rwth_aachen.dc.mvd.bcf;

import javax.vecmath.Point3d;

import org.bimserver.geometry.Matrix;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.ifcopenshell.IfcGeomServerClientEntity;
import org.ifcopenshell.IfcOpenShellEntityInstance;
import org.ifcopenshell.IfcOpenShellModel;

import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import nl.tue.ddss.bcf.BoundingBox;

//Modified by JO, 22/04/2020 and 4/05/2020, 09/02/2022 from the original 
// nl.tue.ddss.bcf.TempGeometry

public class TempGeometry {
	private final String userId;
	private EventBusCommunication communication = EventBusCommunication.getInstance();
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

	public TempGeometry(String userId,IfcOpenShellModel renderEngineModel, long ifcProductExpressId) {
		this.userId = userId;
		this.boundingBox = getBoundingBox(renderEngineModel, ifcProductExpressId);
		if (boundingBox == null) {
			// No need to repeat
			// System.err.println("Does not have a geometry");
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

	private BoundingBox getBoundingBox(IfcOpenShellModel renderEngineModel, long ifcProductExpressId) {
		BoundingBox boundingBox = null;
		IfcOpenShellEntityInstance renderEngineInstance;
		try {
			renderEngineInstance = renderEngineModel.getInstanceFromExpressId((int) ifcProductExpressId); // new version
																											// uses long
			// System.out.println("RenderEngineInstance for "+ifcProductExpressId+" is
			// "+renderEngineInstance);
			if (renderEngineInstance == null) {
				System.err.println("Product of the express id " + ifcProductExpressId + " does not have a geometry");

				return null;
			}
			IfcGeomServerClientEntity geometry = renderEngineInstance.generateGeometry();
			if (geometry != null && geometry.getIndices().length > 0) {
				boundingBox = new BoundingBox();
				double[] tranformationMatrix = new double[16];
				if (renderEngineInstance.getTransformationMatrix() != null) {
					tranformationMatrix = renderEngineInstance.getTransformationMatrix();
					tranformationMatrix = Matrix.changeOrientation(tranformationMatrix);
				} else {
					Matrix.setIdentityM(tranformationMatrix, 0);
				}

				float[] vertices = geometry.getPositions();
				for (int i = 0; i < geometry.getPositions().length; i += 3) {
					processExtends(boundingBox, tranformationMatrix, vertices[i], vertices[i + 1], vertices[i + 2]);
				}
			}
		} catch (RenderEngineException e) {
			communication.post(new CheckerErrorEvent(this.userId,this.getClass().getName(), e.getMessage()));
			e.printStackTrace();
		}
		return boundingBox;
	}

	private void processExtends(BoundingBox boundingBox, double[] transformationMatrix, double x, double y, double z) {
		double[] result = new double[4];
		Matrix.multiplyMV(result, 0, transformationMatrix, 0, new double[] { x, y, z, 1 }, 0);
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
