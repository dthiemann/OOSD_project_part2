package org.uiowa.cs2820.engine;

public class IdStorage implements FileStorage {
	private final String fileType = "ID";
	
	// Get the Identifiers from a given Field
	// -- takes an index integer pointing to location on file
	public <E> byte[] get( E n ){
		// DO SOMETHING
		int index = ( Integer ) n;
		return null;
	}
	
	// Save an Identifier to the file
	// Unless Identifier already exists
	public void put( byte[] f ){
		// DO SOMETHING
	}
	
	// Delete an Identifier from the file
	public void del( byte[] f ){
		// DO SOMETHING
	}
}
