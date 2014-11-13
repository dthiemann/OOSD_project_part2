/*

------------------------------------------
         Checkpoint Class (Tim M)
------------------------------------------
Team 1 (Dylan T) (Jason S) (Joe M) (Tim M)  

*/

package org.uiowa.cs2820.engine;

import org.uiowa.cs2820.engine.Field;
import java.io.*;


public class Checkpoint {
	

	//(in 'a.txt') saves object as byte array
	public static void save(Object O) {
		byte[] data = new byte[(int) file.length()]; 
		data = Utility.convert(O);
		FileOutputStream out = new FileOutputStream(file);
		out.write(data);
		out.close();
	}
	
	//(in 'a.txt') saves byte array as object
	public static Object restore(String file) {
		FileInputStream fs = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		fs.read(b);
		Object O = new Object();
		O = Utility.revert(b);
		return O;
	}
	

	public static void main(String [ ] args){
		try {
			File file = new File("a.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
		
		if (!file.exists()){
			file.createNewFile();
}		
}
}