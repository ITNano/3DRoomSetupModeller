package se.matzlarsson.rsm3d.test;

import javax.swing.JFrame;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

/**
 * Simple test class just to make sure the JOGL libraries are imported correctly to the project.'
 * Created 2015-10-15.
 * 
 * @author Matz Larsson
 * @version 0.1
 */


public class SimpleTestScreen extends JFrame implements GLEventListener {
	
	private static final long serialVersionUID = 1L;
	
	final private int width = 800;
	final private int height = 600;
	
	/**
	 * Creates a window and displays it.
	 */
	public SimpleTestScreen(){
		super("Minimal OpenGL");
		GLProfile profile = GLProfile.get(GLProfile.GL4);
		GLCapabilities capabilities = new GLCapabilities(profile);
		
		GLCanvas canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		
		this.setName("Minimal OpenGL");
		this.getContentPane().add(canvas);
		
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		canvas.requestFocusInWindow();

	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL4 gl = drawable.getGL().getGL4();
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT | GL4.GL_DEPTH_BUFFER_BIT);
		
		// call your draw code here
		
		gl.glFlush();

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
	}

	@Override
	public void init(GLAutoDrawable drawable) {
        GL4 gl = drawable.getGL().getGL4();
        gl.glClearColor(0.153f, 0.682f, 0.376f, 1.0f);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,  int height) {
	}
	
	
	public static void main(String[] args){
		new SimpleTestScreen();
	}
}