package org.opensource_bimserver.bcf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLOffscreenAutoDrawable;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.util.awt.AWTGLReadBufferUtil;

import generated.buildingsmart.bcf.markup.Markup;
import generated.buildingsmart.bcf.visinfo.VisualizationInfo;

@SuppressWarnings("unused")
public class Issue {
    private byte[] imageData;
    private Markup markup;
    private VisualizationInfo visualizationInfo;
    private UUID uuid;

    public Issue(UUID uuid) {
	this.uuid = uuid;
    }

    public Issue(UUID uuid, Markup markup, VisualizationInfo visualizationInfo) {
	this.uuid = uuid;
	this.markup = markup;
	this.visualizationInfo = visualizationInfo;
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
	int width = 200, height = 200;
	BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	Graphics2D ig2 = bi.createGraphics();
	paint(ig2);
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

	GLProfile gl_profile = GLProfile.getDefault();
	GLCapabilities capabilities = new GLCapabilities(gl_profile);
	capabilities.setOnscreen(false);

	GLDrawableFactory factory = GLDrawableFactory.getFactory(gl_profile);
	GLOffscreenAutoDrawable drawable = factory.createOffscreenAutoDrawable(null,capabilities,null,width,height);
	drawable.display();
	drawable.getContext().makeCurrent();

	GL2 gl = drawable.getGL().getGL2();

	gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
	gl.glLoadIdentity();    
	gl.glOrtho(0d, width, height, 0d, -1d, 1d);

	gl.glPointSize(4f);
	gl.glColor3f(1f,0f,0f);    
	gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
	

	BufferedImage im = new AWTGLReadBufferUtil(drawable.getGLProfile(), false).readPixelsToBufferedImage(drawable.getGL(), 0, 0, width, height, true );
	
	return im;
    }
}