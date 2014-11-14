/*

------------------------------------------
         Checkpoint Class (Tim M)
------------------------------------------
Team 1 (Dylan T) (Jason S) (Joe M) (Tim M)  

 */

package org.uiowa.cs2820.engine;

import java.io.*;
import java.util.BitSet;

public class Checkpoint {
	
	private final static File file1 = new File("a.txt");
	private final static File file2 = new File("b.txt");

	// (in 'a.txt') saves object as byte array
<<<<<<< HEAD
	public static void save(Object O, String param) throws Exception {
		File temp = getFile(param);
		checkFile(temp);
		byte[] data = new byte[(int) temp.length()];
=======
	public static void save(Object O) {
		byte[] data = new byte[(int) file.length()];
>>>>>>> FETCH_HEAD
		data = Utility.convert(O);
		try {
			FileOutputStream out = new FileOutputStream(temp);
			out.write(data);
			out.close();
		} catch (Exception e) {
		}
	}

	// (in 'a.txt') saves byte array as object
	public static BitSet restore(String file) throws Exception {
		File temp = getFile(file);
		checkFile(temp);		
		FileInputStream fs = new FileInputStream(temp);
		byte[] b = new byte[(int) temp.length()];
		fs.read(b);
<<<<<<< HEAD
		BitSet O = (BitSet) Utility.revert(b);
=======
		Object O = new Object();
		O = Utility.revert(b);
>>>>>>> FETCH_HEAD
		fs.close();
		return O;
	}

	// returns which file to save/restore
	private static File getFile(String param){ 
 		if( param == "FIELD"){ 
 			return file1; 
 		} 
 		else{ 
 			return file2;  		} 
}
	
	//
	private static void checkFile(File f) throws Exception{
		if (!f.exists()){
			f.createNewFile();
			FileInputStream fs = new FileInputStream(f);
			byte[] b = new byte[(int) f.length()];
			fs.read(b);
			BitSet O = new BitSet();
			O = (BitSet) Utility.revert(b);
			O.clear(0);
			byte[] b1 = new byte[(int) O.length()];
			b1 = Utility.convert(O);
			FileOutputStream out = new FileOutputStream(f);
			out.write(b1);
			out.close();
			fs.close();
			}
	}
}	
	/*
	public static void main(String[] args) {
		try {
			file = new File("a.txt");
			
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {

		}
	}*/