package com.TH.ge.renderCore;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import com.TH.ge.mainCore.AppContainer;

public class Render  extends JPanel {
	private AppContainer app;
	
	public Render(AppContainer ac) {
		app = ac;
	}
	
	public void paintComponent(Graphics g) {
		this.app.update(g);
	}
}
