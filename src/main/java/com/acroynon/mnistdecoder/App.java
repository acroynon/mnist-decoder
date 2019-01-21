package com.acroynon.mnistdecoder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

/**
 * Simple App to load MNIST data from binary files into seperate image files
 * 
 * @author Roynon
 *
 */
public class App {

	public static final int NUM_FILES = 10;
	public static final int NUM_IMAGES = 1000;
	public static final int IMAGE_WIDTH = 28;
	public static final int IMAGE_HEIGHT = 28;
	public static final int IMAGE_SIZE = IMAGE_WIDTH * IMAGE_HEIGHT;
	
	public static void main(String[] args){
		new App().start();
	}
	
	public void start(){	
		ImageBuilder builder = new ImageBuilder(IMAGE_WIDTH, IMAGE_HEIGHT); 
		ArrayUtil arrayUtil = new ArrayUtil();		
		DataImporter importer;

		for(int i=0; i<NUM_FILES; i++){
			importer = new DataImporter("data" + i);
			for(int j=0; j<NUM_IMAGES; j++){
				int[] bytes = importer.readNextBytes(IMAGE_WIDTH * IMAGE_HEIGHT);
				int[][] array = arrayUtil.convertTo2D(bytes, IMAGE_WIDTH, IMAGE_HEIGHT);
				builder.drawArray(array);
				builder.saveToFile("images/_" + i + "/" + i + "_" + j);
				
			}
		}
		
		System.out.println("Finished creating all images!");
	}
	
}
