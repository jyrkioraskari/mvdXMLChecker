package org.opensource_bimserver.bcf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.ifcopenshell.IfcGeomServerClientEntity;
import org.ifcopenshell.IfcOpenShellEntityInstance;
import org.ifcopenshell.IfcOpenShellModel;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLOffscreenAutoDrawable;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.AWTGLReadBufferUtil;

import generated.buildingsmart.bcf.markup.Markup;
import generated.buildingsmart.bcf.visinfo.VisualizationInfo;

@SuppressWarnings("unused")
public class Issue {
    private byte[] imageData;
    private Markup markup;
    private VisualizationInfo visualizationInfo;
    private UUID uuid;

    private Optional<IfcOpenShellModel> renderEngineModel = Optional.empty();
    private Optional<Long> ifcProductExpressId = Optional.empty();

    public Issue(UUID uuid) {
	this.uuid = uuid;
    }

    public Issue(UUID uuid, Markup markup, VisualizationInfo visualizationInfo) {
	this.uuid = uuid;
	this.markup = markup;
	this.visualizationInfo = visualizationInfo;
    }

    public void addRendering(IfcOpenShellModel rm, long ifcProductExpressId) {
	this.renderEngineModel = Optional.of(rm);
	this.ifcProductExpressId = Optional.of(ifcProductExpressId);

    }

    public void setMarkup(Markup markup) {
	this.markup = markup;
    }

    public void setVisualizationInfo(VisualizationInfo visualizationInfo) {
	this.visualizationInfo = visualizationInfo;
    }

    public void setImageData(byte[] imageData) {
	this.imageData = imageData;
    }

    public byte[] getImageData() {
	return imageData;
    }

    public VisualizationInfo getVisualizationInfo() {
	return visualizationInfo;
    }

    public Markup getMarkup() {
	return markup;
    }

    public UUID getUuid() {
	return uuid;
    }

    public void write(ZipOutputStream zipOutputStream) throws IOException, BcfException {
	ZipEntry markup_dir = new ZipEntry(getUuid().toString() + "/");  // JO 2020  fix to be inline with the standard
	zipOutputStream.putNextEntry(markup_dir);
	
	ZipEntry markup = new ZipEntry(getUuid().toString() + "/markup.bcf");
	zipOutputStream.putNextEntry(markup);
	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(Markup.class);
	    Marshaller marshaller = jaxbContext.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    marshaller.marshal(this.markup, zipOutputStream);
	} catch (JAXBException e) {
	    throw new BcfException(e);
	}

	// Modified by JO 24/04/2020
	if (this.visualizationInfo != null) {
	    ZipEntry visualizationInfo = new ZipEntry(getUuid().toString() + "/viewpoint.bcfv");
	    zipOutputStream.putNextEntry(visualizationInfo);
	    try {
		JAXBContext jaxbContext = JAXBContext.newInstance(VisualizationInfo.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(this.visualizationInfo, zipOutputStream);
	    } catch (JAXBException e) {
		throw new BcfException(e);
	    }
	    createDummySnapshot(zipOutputStream);
	}

//                ZipEntry image = new ZipEntry(getUuid().toString() + "/snapshot.png");
//                zipOutputStream.putNextEntry(image);
//                ByteArrayInputStream bais = new ByteArrayInputStream(getImageData());
//                IOUtils.copy(bais, zipOutputStream);
//TODO SNAPSHOT AVAILABLE YET!
    }

    private void createDummySnapshot(ZipOutputStream zipOutputStream) throws IOException {
	ZipEntry snapshot = new ZipEntry(getUuid().toString() + "/snapshot.png");
	zipOutputStream.putNextEntry(snapshot);
	int width = 500, height = 500;
	BufferedImage bi = makeImage(width, height); // new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	Graphics2D ig2 = bi.createGraphics();
	// paint(ig2);
	try {
	    ImageIO.write(bi, "PNG", zipOutputStream);
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    private void paint(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	Font font = new Font("Serif", Font.PLAIN, 32);
	g2.setColor(Color.RED);
	g2.setFont(font);
	g2.drawString("To be done", 50, 70);
    }

    public BufferedImage makeImage(int width, int height) {
	GLU glu = new GLU();
	GLProfile gl_profile = GLProfile.getDefault();
	GLCapabilities capabilities = new GLCapabilities(gl_profile);
	capabilities.setOnscreen(false);

	GLDrawableFactory factory = GLDrawableFactory.getFactory(gl_profile);
	GLOffscreenAutoDrawable drawable = factory.createOffscreenAutoDrawable(null, capabilities, null, width, height);
	drawable.display();
	drawable.getContext().makeCurrent();

	GL2 gl = drawable.getGL().getGL2();
	gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

	gl.glViewport(0, 0, width, height);
	gl.glMatrixMode(GL2.GL_PROJECTION);
	gl.glLoadIdentity();
	System.out.println("this.renderEngineModel.isPresent(): "+this.renderEngineModel.isPresent());
	if (this.renderEngineModel.isPresent()) {
	    System.out.println("GEO");

	    IfcOpenShellEntityInstance renderEngineInstance;
	    try {
		renderEngineInstance = this.renderEngineModel.get().getInstanceFromExpressId(ifcProductExpressId.get().intValue());
		System.out.println("RE: " + ifcProductExpressId);
		if (renderEngineInstance != null) {
		    IfcGeomServerClientEntity geometry = renderEngineInstance.generateGeometry();
		    if (geometry != null && geometry.getIndices().length > 0) {

			double xmax = Float.MIN_VALUE;
			double ymax = Float.MIN_VALUE;
			double zmax = Float.MIN_VALUE;
			double xmin = Float.MAX_VALUE;
			double ymin = Float.MAX_VALUE;
			double zmin = Float.MAX_VALUE;

			int[] indices = geometry.getIndices();
			float[] vertices=geometry.getPositions();
			System.out.println("inx len: "+indices.length);
			for (int i = 0; i < indices.length; i = i + 3) {
			    double x1 = vertices[indices[i] * 3];
			    double y1 = vertices[indices[i] * 3 + 1];
			    double z1 = vertices[indices[i] * 3 + 2];
			    double x2 = vertices[indices[i + 1] * 3];
			    double y2 = vertices[indices[i + 1] * 3 + 1];
			    double z2 = vertices[indices[i + 1] * 3 + 2];
			    double x3 = vertices[indices[i + 2] * 3];
			    double y3 = vertices[indices[i + 2] * 3 + 1];
			    double z3 = vertices[indices[i + 2] * 3 + 2];

			    if (x1 < xmin)
				xmin = x1;
			    if (x2 < xmin)
				xmin = x2;
			    if (x3 < xmin)
				xmin = x3;

			    if (x1 > xmax)
				xmax = x1;
			    if (x2 > xmax)
				xmax = x2;
			    if (x3 > xmax)
				xmax = x3;

			    if (y1 < ymin)
				ymin = y1;
			    if (y2 < ymin)
				ymin = y2;
			    if (y3 < ymin)
				ymin = y3;

			    if (y1 > ymax)
				ymax = y1;
			    if (y2 > ymax)
				ymax = y2;
			    if (y3 > ymax)
				ymax = y3;

			    if (z1 < zmin)
				zmin = z1;
			    if (z2 < zmin)
				zmin = z2;
			    if (z3 < zmin)
				zmin = z3;

			    if (z1 > zmax)
				zmax = z1;
			    if (z2 > zmax)
				zmax = z2;
			    if (z3 > zmax)
				zmax = z3;
			}
			double xscale = xmax - xmin;
			double yscale = ymax - ymin;
			double zscale = zmax - zmin;

			double xmean = xmax - xscale / 2;
			double ymean = ymax - yscale / 2;
			double zmean = zmax - zscale / 2;
			
			gl.glRotatef( 20, 0.0f, 1.0f, 0.0f );  

			for (int i = 0; i < indices.length; i = i + 3) {
			    double x1 = vertices[indices[i] * 3];
			    double y1 = vertices[indices[i] * 3 + 1];
			    double z1 = vertices[indices[i] * 3 + 2];
			    double x2 = vertices[indices[i + 1] * 3];
			    double y2 = vertices[indices[i + 1] * 3 + 1];
			    double z2 = vertices[indices[i + 1] * 3 + 2];
			    double x3 = vertices[indices[i + 2] * 3];
			    double y3 = vertices[indices[i + 2] * 3 + 1];
			    double z3 = vertices[indices[i + 2] * 3 + 2];

			    x1 -= xmean;
			    y1 -= ymean;
			    z1 -= zmean;

			    x2 -= xmean;
			    y2 -= ymean;
			    z2 -= zmean;

			    x3 -= xmean;
			    y3 -= ymean;
			    z3 -= zmean;

			    x1 = (x1 / xscale) * 1.5;
			    y1 = (y1 / yscale) * 1.5;
			    z1 = (z1 / zscale) * 1.5;

			    x2 = (x2 / xscale) * 1.5;
			    y2 = (y2 / yscale) * 1.5;
			    z2 = (z2 / zscale) * 1.5;

			    x3 = (x3 / xscale) * 1.5;
			    y3 = (y3 / yscale) * 1.5;
			    z3 = (z3 / zscale) * 1.5;

			    gl.glBegin(GL2.GL_LINES);
			    gl.glVertex3d(x1, y1, z1);
			    gl.glVertex3d(x2, y2, z2);
			    gl.glVertex3d(x3, y3, z3);
			    gl.glVertex3d(x1, y1, z1);
			    gl.glEnd();
			    System.out.println("i: "+x1+" "+y1+" "+z1+ " - "+x2+" "+y2+" "+z2+" - "+x3+" "+y3+" "+z3);
			}
		    }
		}
	    } catch (RenderEngineException e) {
		e.printStackTrace();
	    }

	    gl.glFlush();
	}
	System.out.println("done");
	BufferedImage im = new AWTGLReadBufferUtil(drawable.getGLProfile(), false).readPixelsToBufferedImage(drawable.getGL(), 0, 0, width, height, true);
	return im;
    }

}