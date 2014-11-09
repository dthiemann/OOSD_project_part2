package org.uiowa.cs2820.engine;

public class IdStorage implements FileStorage {
	private final String fileType = "ID";
	
	// Get the Identifiers from a given Field
	// -- takes an index integer pointing to location on file
	public byte[] get( int index ){
		// DO SOMETHING
		return null;
	}
	
	// Save an Identifier to the file
	// Requires getting all Identifiers,
	//   appending new ID to list, then
	//   re-converting to byte[], splitting into 1k blocks, and writing to file
	public void put( byte[] f ){
		// DO SOMETHING
	}
	
	// Delete an Identifier from the file
	public void del( byte[] f ){
		// DO SOMETHING
	}
	
	private byte[] rebuild( int index ){
		// DO SOMETHING
		return null;
	}
}
