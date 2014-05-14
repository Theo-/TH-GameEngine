package com.TH.ge.mainCore;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class State {
	protected AppContainer container;
	
	public State(AppContainer ac) {
		container = ac;
	}
	
	public void update(AppContainer container, State st) {
		
	}
	
	public void draw(AppContainer container, State st, Graphics g) {
		
	}
	
	public void enter() {
		
	}

	/**
	 * Method called every time a key event is received
	 * @param type The type of the event
	 * Can Be
	 * - typed
	 * - released
	 * - pressed
	 * @param evt
	 * The KeyEvent associated
	 */
	public void onKeyEvent(String type, KeyEvent evt) {
		
	}
	
	/**
	 * Method called every time a mouse event is received
	 * @param type The type of the event
	 * Can Be
	 * - clicked
	 * - exited
	 * - entered
	 * - released
	 * - pressed
	 * @param evt
	 * The KeyEvent associated
	 */
	public void onMouseEvent(String type, MouseEvent evt) {
		
	}
	
	/**
	 * Event system. Method called when a event is fired
	 * @param type The name of the event
	 * @param param The only parameter
	 */
	public void onEvent(String type, Object param) {
		
	}
	
	// Events
	/**
	 * Fire an event received by onEvent()
	 * @param type Name of the event
	 * @param param Parameter
	 */
	public void fireEvent(String type, Object param) {
		this.container.fireEvent(type, param);
	}
	
	/**
	 * Fire an event received by onEvent() with a null parameter
	 * @param type Name of the event
	 */
	public void fireEvent(String type) {
		this.container.fireEvent(type, null);
	}
	
	// ---------------------------
	public AppContainer getContainer() {
		return container;
	}
}
