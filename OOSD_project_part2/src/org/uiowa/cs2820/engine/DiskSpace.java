package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.io.RandomAccessFile;
//Written by Jason Sherman

//Whatever calls this should send a FileName of either ID or FIELD
public class DiskSpace {
	
	public static void WriteArea(int area, byte[] data, String FileName) throws IOException {
		area = area*1024;
		RandomAccessFile file = new RandomAccessFile(FileName, "rw");
		file.seek(area);
		file.write(data);
		file.close();
    }
  
	public static byte[] ReadArea(int area, String FileName) throws IOException {
		area = area*1024;
		RandomAccessFile file = new RandomAccessFile(FileName, "r");
		file.seek(area);
		byte[] bytes = new byte[1024]; //need to specify size of byte array somehow?
		file.read(bytes);
		file.close();
		return bytes;

  	}
}
