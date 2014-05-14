package com.TH.ge.mainCore;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

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

	public void keyPressed(KeyEvent evt) {
		
	}
	
	// ---------------------------
	public AppContainer getContainer() {
		return container;
	}
}
