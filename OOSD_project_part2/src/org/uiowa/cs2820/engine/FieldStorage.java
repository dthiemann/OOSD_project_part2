package org.uiowa.cs2820.engine;

import java.io.IOException;

/**
 * Joe Maule
 * CS:2820, Fall 2014
 *
 * Purpose:
 * 	Used by a Database to read/write a Field object from/to a file
 * 	  + FieldStorage data contains a pointer (index) to the first 1kb of data
 * 		of its corresponding Identifiers in its respective file, in order to
 * 		easily retrieve that data in linear time.
 */

public class FieldStorage {
	// Class variable
	private final String FILETYPE = "FIELD";
	
	// Gets the Field at a given index from the file; returns as a byte array
	public byte[] get( int index ) throws IOException {
		Kblock kb = new Kblock( DiskSpace.ReadArea( index, FILETYPE ) );
		return kb.getData();
	}
	
	// Gets the pointer (starting index) for the Identifiers of a given Field
	public int getPointer( byte[] f ) throws IOException {
		return findField( f, "POINTER" );
	}
	
	// Get the index of a given Field in its file
	public int getIndex( byte[] f ) throws IOException {
		return findField( f, "INDEX" );
	}
		
	// Save a Field to the file, unless Field already exists
	public void put( byte[] f ) throws IOException {
		// Find Field in file
		int fIndex = this.getIndex( f );
		if( fIndex == -1 ){
			// Get index of free block from Field bit array
			int index = Allocation.allocate(FILETYPE);
			// Get index of free block from Identifier bit array (for ID pointer)
			int pointer = Allocation.getID();
			// Create 1kb block and write to file
			Kblock kb = new Kblock( index, f );
			DiskSpace.WriteArea( index, kb.getBlock(), FILETYPE );
		}
	}
	
	// Search for a given Field and return the data requested
	private int findField( byte[] f, String intType ) throws IOException {
		// Iterate through the Field file to locate the given Field
		Field paramField = (Field) Utility.revert( f );
		int allocSize = Allocation.size();
		for( int index = 1; index < allocSize; index++ ){
			Kblock kb = new Kblock( DiskSpace.ReadArea( index, FILETYPE ) );
			Field kbField = (Field) Utility.revert( kb.getData() );
			if( paramField.equals( kbField ) ){
				if( intType == "INDEX" ){
					return index;
				}
				else{
					return kb.getPointer();
				}
			}
		}
		// If Field not found:
		return -1;
	}

}
