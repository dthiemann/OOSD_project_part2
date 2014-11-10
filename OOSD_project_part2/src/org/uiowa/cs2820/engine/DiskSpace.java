package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DiskSpace {
	
	public void WriteArea(int area, byte[] data, String FileName) throws IOException {
		RandomAccessFile file = new RandomAccessFile(FileName, "rw");
		file.seek(area);
		file.write(data);
		file.close();
    }
  
	public byte[] ReadArea(int area, String FileName) throws IOException {
		RandomAccessFile file = new RandomAccessFile(FileName, "r");
		file.seek(area);
		byte[] bytes = new byte[1024]; //need to specify size of byte array somehow?
		file.read(bytes);
		file.close();
		return bytes;

  	}
//Where exactly will it write this file? Will it be able to find it once it is written?
//Maybe add 3rd method to see what file name I am using from keystorage/idstorage 
//so that i can send to correct file for the parameter "FileName":ID or KEY
}
