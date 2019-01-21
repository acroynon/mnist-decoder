package com.acroynon.mnistdecoder;

/**
 * util to manage array manipulation
 * 
 * @author Roynon
 *
 */
public class ArrayUtil {
	
	public int[][] convertTo2D(int[] arr, int width, int height){
		int[][] result = new int[width][height];
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				result[x][y] = arr[y*width + x];
			}
		}
		return result;
	}
	
}
