package com.acroynon.mnistdecoder;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Import data from a binary file into an int array
 * 
 * @author Roynon
 *
 */
public class DataImporter {

	private DataInputStream in;
	
	public DataImporter(String filename){
		in = new DataInputStream(getClass().getResourceAsStream("/" + filename));
	}
	
	/**
	 * Read the next number of bytes from the loaded binary file
	 * @param numberBytes
	 * @return array of bytes read
	 */
	public int[] readNextBytes(int numberBytes){
		int[] intArr = new int[numberBytes];
		try {
			for(int i=0; i<numberBytes; i++){
					intArr[i] = in.readUnsignedByte();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return intArr;
	}
	
	
	
}
