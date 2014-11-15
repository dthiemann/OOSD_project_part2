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

	// saves object as byte array
	public static void save(Object O, String param) throws Exception {
		File temp = getFile(param);
		checkFile(temp);
		byte[] data = new byte[(int) temp.length()];
		data = Utility.convert(O);
		try {
			FileOutputStream out = new FileOutputStream(temp);
			out.write(data);
			out.close();
		} catch (Exception e) {
		}
	}

	// restores byte array as object
	public static BitSet restore(String file) throws Exception {
		File temp = getFile(file);
		checkFile(temp);		
		FileInputStream fs = new FileInputStream(temp);
		byte[] b = new byte[(int) temp.length()];
		fs.read(b);
		BitSet O = (BitSet) Utility.revert(b);
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

	// makes first bit in array a 0
	private static void checkFile(File f) throws Exception{
		if (!f.exists()){
			f.createNewFile();
			BitSet O = new BitSet();
			O.set(0);
			byte[] b = new byte[(int) O.length()];
			b = Utility.convert(O);
			FileOutputStream out = new FileOutputStream(f);
			out.write(b);
			out.close();
			}
	}
}	
