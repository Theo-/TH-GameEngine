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
	public int MENU = 0;
	public int GAME = 1;
	public int GAMEOVER = 2;
	
	private int STATE = MENU;
	private HashMap<Integer, Class<?>> states = new HashMap<Integer, Class<?>>();
	private State current = null;
	
	public JFrame window;
	private Timer timer;
	private Render render;
	private Resources resources;
	
	public AppContainer() throws IOException {
		window = new JFrame();
		
		window.setVisible(true);
		window.setTitle("Pop Wings");
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
	
	public void startApp() {
		timer = new Timer();
		timer.schedule(this, 0, 100/6);
	}
	
	public void addState(int state_id, Class state_class) {
		this.states.put(state_id, state_class);
	}
	
	public void update(Graphics g) {
		if(current == null) { return;}
		
		current.update(this, current);
		current.draw(this, current, g);
	}
	
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

	// Mouse LISTENER
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub 
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	// KEYL
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		current.keyPressed(evt);
	}
}
