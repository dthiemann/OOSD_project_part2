package org.uiowa.cs2820.engine;

import java.util.Arrays;
import java.util.*;

public class IdStorage implements FileStorage {
	private final String fileType = "ID";
	
	// Get the Identifiers from a given Field
	// -- takes an index integer pointing to location on file
	public ArrayList<Object> get( int index ){
		// DO SOMETHING
		//return rebuild(index);
		return null;
	}
	
	// Save an Identifier to the file
	// Requires getting all Identifiers,
	//   appending new ID to list, then
	//   re-converting to byte[], splitting into 1k blocks, and writing to file
	public void put( byte[] id ){
		// DO SOMETHING
		
		// what specifically is going to get passed to this method?
		// a single identifier? or a full arraylist as byte[]?
		
		/*
		 * How do we determine which key these identifiers 
		 * belong too?
		 */
		
	}
	
	
	// Read all Identifier blocks from file and recompile them into 1 byte array
	private byte[] rebuild( int index ){
		// DO SOMETHING
		Kblock kb = DSPACE_read( index );
		byte[] id = kb.getData();
		
		while( kb.getPointer() != 0 ){
			// Get next 1kb block of data
			kb = DSPACE_read( kb.getPointer() );
			
			// Expand id array size to add new 1kb block data
			byte[] tempid = id.clone();
			id = new byte[ id.length + kb.getData().length ];
			
			// Add new data to id array
			System.arraycopy( tempid, 0, id, 0, tempid.length);
			System.arraycopy( kb.getData(), 0, id, 0, tempid.length);
		}
		
		return id;
	}
}
