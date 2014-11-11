package org.uiowa.cs2820.engine;

import java.util.*; 

public class LinearFileDatabase implements Database {
	FieldStorage f_storage;
	IdStorage id_storage;
	
	public LinearFileDatabase() {
		this.f_storage = new FieldStorage();
		this.id_storage = new IdStorage();
	}

	@Override
	public Node fetch(byte[] key) {
		// TODO Auto-generated method stub
		//Node myNode = f_storage.get(key);
		
		/*
		 * Something needs to happen here! Not to sure what.
		 * Need to access the files using a byte array. 
		 */
		
		int my_pointer = f_storage.getPointer(key);
		ArrayList<Object> identifiers = id_storage.get(my_pointer);
		 		
		return my_node;
	}

	@Override
	public void delete(byte[] key, String id) {
		
		/*
		 * Don't need to worry about this for the overall implementaion
		 */

	}

	@Override
	public void store(byte[] key, String id) {
		// TODO Auto-generated method stub
		
		// this is wrong and needs to be changed
		Kblock myNode = new Kblock(key);
		
		
	}

}
