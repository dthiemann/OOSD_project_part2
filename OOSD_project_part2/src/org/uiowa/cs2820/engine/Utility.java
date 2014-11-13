package org.uiowa.cs2820.engine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Joe Maule
 * CS:2820, Fall 2014
 *
 * Purpose:
 * 	Convert data into a byte array;
 * 	Restore data from a byte array
 * 
 * Note:
 * 	These methods were pulled from the Field class so other classes were
 * 	not dependent upon calling methods from that class.
 */

public class Utility {

	public static byte[] convert(Object O) {
		  // private method converts objects into byte array
		  ByteArrayOutputStream M = new ByteArrayOutputStream();
		  ObjectOutput N = null;
		  try {
			N = new ObjectOutputStream(M);
			N.writeObject(O);
		    } 
		  catch (IOException e) {
	        return null; // wrong, but should not happen	    	
		    }
		  return M.toByteArray();
		  }
		
		public static Object revert(byte[] seq) {
		  // private method converts byte array into an object
		  Object O = null;  // default value
		  try {
			ByteArrayInputStream M = new ByteArrayInputStream(seq);
			ObjectInputStream N = new ObjectInputStream(M);
			O = N.readObject();
			}
		  catch (Exception e) { };
			return O;
		  }
	
}
