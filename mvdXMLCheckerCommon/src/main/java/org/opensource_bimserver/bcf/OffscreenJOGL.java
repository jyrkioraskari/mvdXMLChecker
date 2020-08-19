package org.opensource_bimserver.bcf;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

class OffscreenJOGL implements GLEventListener {
    public void init(GLAutoDrawable drawable) {
        drawable.getContext().makeCurrent();
        //Other init code here
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //Called at least once after init(...) and before display(...)
    }

    public void dispose(GLAutoDrawable drawable) {
        //Dispose code here
    }

    @Override
    public void display(GLAutoDrawable drawable) {
	// TODO Auto-generated method stub
	
    }
}