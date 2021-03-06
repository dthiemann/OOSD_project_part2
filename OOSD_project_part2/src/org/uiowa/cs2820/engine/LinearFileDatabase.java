package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*; 

/*
 * @author: Dylan Thiemann
 * 
 * implements the Database interface. Allows the user to store
 * indexed keys and values in files on the disk, as opposed
 * to using a built-in Java data structures
 * 
 */

public class LinearFileDatabase implements Database {
	FieldStorage f_storage;
	IdStorage id_storage;
	
	public LinearFileDatabase() {
		this.f_storage = new FieldStorage();
		this.id_storage = new IdStorage();
	}
	
	public LinearFileDatabase(boolean isTest) {
		if (isTest) {
			this.f_storage = new MockFieldStorage();
			this.id_storage = new MockIdStorage();
		} else {
			this.f_storage = new FieldStorage();
			this.id_storage = new IdStorage();
		}
	}

	@Override
	public Node fetch(byte[] key) {
		// TODO Auto-generated method stub
		if (key == null) {
			return null;
		}
			
		ArrayList<Object> identifiers = null;
		
		/* 
		 * Try to get a pointer to our values from
		 * a given key
		 */
		try {	
			int my_pointer = f_storage.getPointer(key);
			identifiers = id_storage.get(my_pointer);	
		} catch (IOException e) {
			
			System.err.println("Caught IOException: " + e.getMessage());
			return null;
		}
		
		/*
		 * Create a new node to return to the user by iterating
		 * through the ArrayList<Object> instance and adding it
		 * to the element
		 */
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
		 * Don't need to worry about this for the overall implementation
		 */
	}

	@Override
	public void store(byte[] key, String id) {
		// TODO Auto-generated method stub
		try {
			f_storage.put(key);
			
			/* Get a pointer to our id_storage */
			int pointer = f_storage.getPointer(key);
			id_storage.put(pointer, id);
			
		} catch(IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}

}
