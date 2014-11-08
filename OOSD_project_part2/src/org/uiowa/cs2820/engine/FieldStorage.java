package org.uiowa.cs2820.engine;

public class FieldStorage implements FileStorage {
	private final String fileType = "FIELD";
	
	// Get the Identifiers from a given Field
	// -- takes a byte array Field
	// -- returns byte array of Identifiers
	public <E> byte[] get( E n ){
		// DO SOMETHING
		byte[] f = ( byte[] ) n;
		return null;
	}
	
	// Save a Field to the file
	// Unless Field already exists
	public void put( byte[] f ){
		// DO SOMETHING
	}
	
	// Delete a Field from the file
	public void del( byte[] f ){
		// DO SOMETHING
	}

}
