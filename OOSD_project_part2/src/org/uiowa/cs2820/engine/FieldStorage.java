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
			Field curField = (Field) Field.revert( kb.getData() );
			Field inputField = (Field) Field.revert(f);
			if( curField.equals(inputField) ){
				return kb.getPointer();
			}
		}
		return -1;
	}
	
	// Get the index in Allocate for a given Field
	// -- takes a byte array Field
	// -- returns index integer for Allocate bit array
	public int getIndex( Field f ){
		// need to fix method names  *** assuming Allocate and DiskSpace are static??
		for( int index = 0; index < ALLOC_size(); index++ ){
			Kblock kb = DSPACE_read( index, fileType );
			Field curField = (Field) Field.revert( kb.getData() );
			if( curField.equals(f) ){
				return index;
			}
		}
		return -1;
	}
	
	
	
	
	// Save a Field to the file, unless Field already exists
	public void put( byte[] f ){
		// DO SOMETHING
		
		// find field in file
		Field tempField = (Field) Field.revert( f );
		int pointer = this.getPointer( tempField );
		if( pointer == -1 ){
			// get free block from Allocate bit array
			int index = ALLOC_alloc();
			// create 1kb block for file
			Kblock kb = new Kblock( pointer, f );
			DSPACE_write( index, kb, fileType );
		}
	}
	
	// Delete a Field from the file
	public void del( byte[] f ){
		// DO SOMETHING
		
		// find field in file
		Field tempField = (Field) Field.revert( f );
		int index = this.getIndex( tempField );
		if( index != -1 ){
			// reset Allocate bit array
			ALLOC_free( index );
			// clear 1kb block on file
			byte[] empty = new byte[1000];
			DSPACE_write( index, empty, fileType );
			// NEED TO CLEAR IdSTORAGE AS WELL
		}
		
		
	}

}
