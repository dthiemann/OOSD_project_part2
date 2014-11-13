package org.uiowa.cs2820.engine;

import java.io.IOException;
//import java.util.Arrays;


public class FieldStorage {
	private final String FILETYPE = "FIELD";
	
	// Get the Field at a given index from the file
	// Returns as byte array
	public byte[] get( int index ) throws IOException {
		Kblock kb = new Kblock( DiskSpace.ReadArea( index, FILETYPE ) );
		return kb.getData();
	}
	
	// Get the starting index (pointer) for Identifiers from a given Field
	// -- takes a byte array Field
	// -- returns pointer integer of Identifiers
	public int getPointer( byte[] f ) throws IOException {
		// fix comments
		int allocSize = Allocation.size();
		for( int index = 1; index < allocSize; index++ ){
			Kblock kb = new Kblock( DiskSpace.ReadArea( index, FILETYPE ) );
			Field paramField = (Field) Utility.revert( f );
			Field kbField = (Field) Utility.revert( kb.getData() );
			if( paramField.equals( kbField ) ){
				return kb.getPointer();
			}
		}
		return -1;
	}
	
	// Get the index of a given Field in its file
	// -- takes a byte array Field
	// -- returns index integer for Field
	public int getIndex( byte[] f ) throws IOException {
		// fix comments
		int allocSize = Allocation.size();
		for( int index = 1; index < allocSize; index++ ){
			Kblock kb = new Kblock( DiskSpace.ReadArea( index, FILETYPE ) );
			Field paramField = (Field) Utility.revert( f );
			Field kbField = (Field) Utility.revert( kb.getData() );
			if( paramField.equals( kbField ) ){
				return index;
			}
		}
		return -1;
	}
	
	
	// Save a Field to the file, unless Field already exists
	public void put( byte[] f ) throws IOException {
		// find field in file
		int fIndex = this.getIndex( f );
		if( fIndex == -1 ){
			// get free block from Allocate Field bit array
			int index = Allocation.allocate(FILETYPE);
			// get free block from Allocate Identifier bit array (without setting it)
			int pointer = Allocation.allocateID();
			// create 1kb block for file
			Kblock kb = new Kblock( index, f );
			DiskSpace.WriteArea( index, kb.getBlock(), FILETYPE );
		}
	}

}
