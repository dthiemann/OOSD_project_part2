package org.uiowa.cs2820.engine;

import java.util.Arrays;



public class FieldStorage implements FileStorage {
	private final String fileType = "FIELD";
	
	
	// Get the Field at a given index from the file
	// Returns as byte array
	public byte[] get( int index ){
		Kblock kb = DSPACE_read( index, fileType );
		return kb.getData();
	}
	
	
	// Get the starting index (pointer) for Identifiers from a given Field
	// -- takes a byte array Field
	// -- returns pointer integer of Identifiers
	public int getPointer( byte[] f ){
		// need to fix method names  *** assuming Allocate and DiskSpace are static??
		for( int index = 0; index < ALLOC_size(); index++ ){
			Kblock kb = DSPACE_read( index, fileType );
			Field paramField = (Field) Field.revert( f );
			Field kbField = (Field) Field.revert( kb.getData() );
			if( paramField.equals( kbField ) ){
				return kb.getPointer();
			}
		}
		return -1;
	}
	
	// Get the index in Allocate for a given Field
	// -- takes a byte array Field
	// -- returns index integer for Allocate bit array
	public int getIndex( byte[] f ){
		// need to fix method names  *** assuming Allocate and DiskSpace are static??
		for( int index = 0; index < ALLOC_size(); index++ ){
			Kblock kb = DSPACE_read( index, fileType );
			Field paramField = (Field) Field.revert( f );
			Field kbField = (Field) Field.revert( kb.getData() );
			if( paramField.equals( kbField ) ){
				return index;
			}
		}
		return -1;
	}
	
	
	// Save a Field to the file, unless Field already exists
	public void put( byte[] f ){
		// DO SOMETHING
		
		// find field in file
		int pointer = this.getPointer( f );
		if( pointer == -1 ){
			// get free block from Allocate bit array
			int index = ALLOC_alloc();
			// create 1kb block for file
			Kblock kb = new Kblock( pointer, f );
			DSPACE_write( index, kb, fileType );
		}
	}

}
