package com.TH.ge.mainCore;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Resources {
	// Saved images
	private HashMap<String, Image> loaded_images;
	
	private ClassLoader class_loader_instance;
	
	public Resources() throws IOException {
		class_loader_instance = Thread.currentThread().getContextClassLoader();
		
		loaded_images = new HashMap<String, Image>();
	}
	
	/**
	 * Load image from a source folder
	 * @param name The name of the image (with the extension)
	 * @return the image
	 * @throws IOException
	 */
	public Image getImageResource(String name) throws IOException {
		if(loaded_images.containsKey(name)) {
			this.loadImageResource(name);
		}
		
		Image image = loaded_images.get(name);
		return image;
	}
	
	public void loadImageResource(String name) throws IOException {
		Image image = ImageIO.read(class_loader_instance.getResourceAsStream(name));
	}
}
