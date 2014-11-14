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
	static File file;

	// (in 'a.txt') saves object as byte array
	public static void save(Object O) {
		byte[] data = new byte[(int) file.length()];
		data = Utility.convert(O);
		try {
			FileOutputStream out = new FileOutputStream(file);
			out.write(data);
			out.close();
		} catch (Exception e) {

		}
	}

	// (in 'a.txt') saves byte array as object
	public static Object restore(String file) throws Exception {
		FileInputStream fs = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		fs.read(b);
		Object O = new Object();
		O = Utility.revert(b);
		fs.close();
		return O;
	}

	public static void main(String[] args) {
		try {
			file = new File("a.txt");
			//BufferedReader br = new BufferedReader(new FileReader(file));

			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {

		}
	}

}