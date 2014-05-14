package com.TH.ge.mainCore;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import com.TH.ge.renderCore.Render;

public class AppContainer extends TimerTask implements KeyListener, MouseListener {
	private HashMap<Integer, Class<?>> states = new HashMap<Integer, Class<?>>();
	private State current = null;
	private int STATE;
	
	public JFrame window;
	private Timer timer;
	private Render render;
	private Resources resources;
	
	private String window_name;
	
	public AppContainer(String name) throws IOException {
		window = new JFrame();
		window_name = name;
		
		window.setVisible(true);
		window.setTitle(window_name);
		window.setSize(new Dimension(1280,768));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		render = new Render(this);
		window.setContentPane(render);
		
		window.addKeyListener(this);
		window.addMouseListener(this);	
		
		resources = new Resources();
	}
	
	public void setWindowSize(int width, int height) {
		window.setSize(new Dimension(width, height));
	}
	public void setWindowSize(Dimension dimensions) {
		window.setSize(dimensions);
	}
	
	/**
	 * Start the application timer
	 */
	public void startApp() {
		timer = new Timer();
		timer.schedule(this, 0, 100/6);
	}
	
	/**
	 * Stopping the application timer
	 */
	public void stopApp() {
		timer.cancel();
	}
	
	/**
	 * Add a possible state to the application
	 * @param state_id ID of the state
	 * @param state_class The class (like MyClass.class)
	 */
	public void addState(int state_id, Class state_class) {
		this.states.put(state_id, state_class);
	}
	
	/**
	 * Calling the updates methods of the current state
	 * @param g Graphics object
	 */
	public void update(Graphics g) {
		if(current == null) { return;}
		
		current.update(this, current);
		current.draw(this, current, g);
	}
	
	/**
	 * Create the class of the desirated State
	 * @param state The ID of the state
	 */
	public void enterState(int state) {
		try {
			STATE = state;
			Class<?> tocreate = this.states.get(state);
			Constructor<?> constructor = tocreate.getConstructor(AppContainer.class);
			State st = (State)constructor.newInstance(new Object[] { this });
			current = st;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.run();
	}

	@Override
	public void run() {
		this.render.repaint();
	}
	
	public void fireEvent(String name, Object param) {
		this.current.onEvent(name, param);
	}

	// Mouse Listener
	@Override
	public void mouseClicked(MouseEvent evt) {
		current.onMouseEvent("clicked", evt);
		
	}

	@Override
	public void mouseEntered(MouseEvent evt) {
		current.onMouseEvent("entered", evt);
		
	}

	@Override
	public void mouseExited(MouseEvent evt) {
		current.onMouseEvent("exited", evt);
		
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		current.onMouseEvent("pressed", evt);
		
	}

	@Override
	public void mouseReleased(MouseEvent evt) {
		current.onMouseEvent("released", evt);
		
	}

	// KEY Listener
	@Override
	public void keyPressed(KeyEvent evt) {
		current.onKeyEvent("pressed", evt);
		
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		current.onKeyEvent("released", evt);
		
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		current.onKeyEvent("typed", evt);
	}
}
