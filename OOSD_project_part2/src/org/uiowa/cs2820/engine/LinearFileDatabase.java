package org.uiowa.cs2820.engine;

import java.io.IOException;
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
		ArrayList<Object> identifiers = null;
		/* Key a pointer to our value list */
		try {	
			int my_pointer = f_storage.getPointer(key);
			identifiers = id_storage.get(my_pointer);	
		} catch (IOException e) {
			
			System.err.println("Caught IOException: " + e.getMessage());
		}
		
		Node my_node = new Node(key, (String)identifiers.get(0));
		
		/* Need to add each string individually to the new node */
		for (int i = 1; i < identifiers.size(); i++) {
			String temp = (String)identifiers.get(i);
			my_node.add(temp);
		}
		
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
		try {
			f_storage.put(key);
		} catch(IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}

}
