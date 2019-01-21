package com.acroynon.mnistdecoder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Create images, draw graphics, and image save to disk
 * 
 * @author Roynon
 *
 */
public class ImageBuilder {

	private BufferedImage bi;
	
	public ImageBuilder(int width, int height){
		bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	}
	
	/**
	 * Draw graphics from a 2D array
	 * @param array, contains values for the pixel values (greyscale)
	 */
	public void drawArray(int[][] array){
		int width = array.length;
		int height = array[0].length;
		
		Graphics g = bi.getGraphics();
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				int c = array[x][y];
				g.setColor(new Color(c, c, c));
				g.fillRect(x, y, 1, 1);
			}
		}
	}
	
	/**
	 * save the created image to disk 
	 * @param filename
	 */
	public void saveToFile(String filename){
		File file = new File(filename + ".jpg");
		file.mkdirs();
		try {
			ImageIO.write(bi, "jpg", file);
		} catch (Exception e) {
			System.out.println("Error while saving file: " + filename + ". Will retry in 1 second.");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				System.out.println("Error while waiting 1 second, will retry now.");
			}
			
			saveToFile(filename);
		}
	}
}
