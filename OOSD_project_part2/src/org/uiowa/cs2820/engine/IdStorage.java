package org.uiowa.cs2820.engine;

import java.util.ArrayList;;

/**
 * Joe Maule
 * CS:2820, Fall 2014
 *
 * Purpose:
 * 	Used by a Database to read/write an Identifier object from/to a file
 * 	  + Identifiers are of the form ArrayList<Object>
 * 	  + More specifically, in this iteration of the Project, it is an ArrayList<String>
 */

public class IdStorage {
	// Class variables
	private final String FILETYPE = "ID";
	private final int MAXSIZE = 1016;		// = 1kb - (2) 4-byte Integers
	
	// Get the list of Identifiers for a given Field
	@SuppressWarnings("unchecked")
	public ArrayList<Object> get( int index ) throws Exception {
		// Read the first 1kb of data from file
		Kblock kb = new Kblock( DiskSpace.ReadArea( index, FILETYPE ) );
		byte[] id = kb.getData();
		
		// If Identifiers data is larger than one 1kb of data
		while( kb.getPointer() != 0 ){
			// Get next 1kb block of data
			kb = new Kblock( DiskSpace.ReadArea( kb.getPointer(), FILETYPE ) );
			// Expand Identifier array size to add new 1kb block data
			byte[] tempid = id.clone();
			id = new byte[ tempid.length + kb.getData().length ];
			// Add new data to Identifier array
			System.arraycopy( tempid, 0, id, 0, tempid.length);
			System.arraycopy( kb.getData(), 0, id, 0, kb.getData().length);
		}
		// Convert data to ArrayList and return to caller
		ArrayList<Object> idList = (ArrayList<Object>) Utility.revert( id );
		return idList;
	}
	
	// Save an Identifier to the file, unless it already exists
	public void put( int startIndex, Object id ) throws Exception {
		// Add new Identifier to list
		ArrayList<Object> idList = this.get( startIndex );
		if( idList == null ){
			idList = new ArrayList<Object>();
		}
		if( idList.contains( id )  ){
			return;
		}
		idList.add( id );
		byte[] idData = Utility.convert( idList );
		
		// "Clear" the data from file for writing new data
		this.freePointers( startIndex );
		
		// Split data into 1kb blocks of data and write to file
		int start = 0;
		int index = Allocation.allocate( FILETYPE );
		int pointer = 0;
		
		do{
			// Get relevant info for a block of data
			int size = Math.min( idData.length, MAXSIZE );
			byte[] kbData = new byte[size];
			System.arraycopy( idData, start, kbData, 0, size);
			
			// Create new 1kb block
			if( size > MAXSIZE ){
				pointer = Allocation.allocate( FILETYPE );
			}
			else{
				pointer = 0;
			}
			
			Kblock kb = new Kblock( pointer, kbData );

			// Write block of data to file
			DiskSpace.WriteArea( index, kb.getBlock(), FILETYPE );
			// Adjust index of data array to point to next set of data
			start += size;
			index = pointer;
			
		} while( start < idData.length );
	}
	
	// Get all pointers for Identifier blocks of data,
	// and mark their locations in file as "empty" for rewriting new data
	private void freePointers( int index ) throws Exception {
		int pointer = index;
		do{
			Allocation.free( pointer, FILETYPE );
			Kblock kb = new Kblock( DiskSpace.ReadArea( pointer, FILETYPE ) );
			pointer = kb.getPointer();
		} while( pointer != 0 );
	}

}
