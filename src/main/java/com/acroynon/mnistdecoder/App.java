package com.acroynon.mnistdecoder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class App {

	public static void main(String[] args) throws IOException, URISyntaxException{
		new App();
	}
	
	public App() throws IOException, URISyntaxException{
		// properties
		int imgW = 28;
		int imgH = 28;
		int size = imgW * imgH;
		// Load File as byte[]
		DataInputStream in = new DataInputStream(getClass().getResourceAsStream("/data0"));
		int[] intArr = new int[size];
		
		for(int i=0; i<size; i++){
			intArr[i] = in.readUnsignedByte();
		}
		
//		
		// create image from byte[]
		BufferedImage bi = new BufferedImage(imgW, imgH, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = bi.getGraphics();
		for(int y=0; y<imgH; y++){
			for(int x=0; x<imgW; x++){
				int c = intArr[(y*imgW) + x];
				g.setColor(new Color(c, c, c));
				g.fillRect(x, y, 1, 1);
			}
		}
		
		// save image file
		ImageIO.write(bi, "jpg", new File("zero.jpg"));
				

	}
	
}
