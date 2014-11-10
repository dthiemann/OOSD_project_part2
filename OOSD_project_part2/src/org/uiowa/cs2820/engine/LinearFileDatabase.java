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
		 * Need to access the files using a byte array
		 */
		
		return null;
	}

	@Override
	public void delete(byte[] key, String id) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void store(byte[] key, String id) {
		// TODO Auto-generated method stub
		
	}

}
