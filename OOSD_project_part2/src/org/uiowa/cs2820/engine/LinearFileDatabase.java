package org.uiowa.cs2820.engine;

public class LinearFileDatabase implements Database {
	FieldStorage f_storage;
	
	public LinearFileDatabase() {
		this.f_storage = new FieldStorage();
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
		Node my_node =  (Node) Field.revert(f_storage.get(my_pointer));
		
		return my_node;
	}

	@Override
	public void delete(byte[] key, String id) {
		// TODO Auto-generated method stub
		
		/*
		 * Field(Key?)Storage.java needs to change so I can 
		 * pass in these values in one function call. In order to delete
		 * the appropriate value!
		 */

	}

	@Override
	public void store(byte[] key, String id) {
		// TODO Auto-generated method stub
		
		// this is wrong and needs to be changed
		Kblock myNode = new Kblock(key);
		
		
	}

}
