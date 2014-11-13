package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.ArrayList;;

public class IdStorage {
	private final String FILETYPE = "ID";
	private final int MAXSIZE = 1016;	// = 1kb - 2 4-byte Integers
	
	// Get the Identifiers from a given Field
	// -- takes an index integer pointing to location on file
	@SuppressWarnings("unchecked")
	public ArrayList<Object> get( int index ) throws IOException {
		// DO SOMETHING
		Kblock kb = new Kblock( DiskSpace.ReadArea( index, FILETYPE ) );
		byte[] id = kb.getData();
		
		while( kb.getPointer() != 0 ){
			// Get next 1kb block of data
			kb = new Kblock( DiskSpace.ReadArea( kb.getPointer(), FILETYPE ) );
			
			// Expand id array size to add new 1kb block data
			byte[] tempid = id.clone();
			id = new byte[ tempid.length + kb.getData().length ];
			
			// Add new data to id array
			System.arraycopy( tempid, 0, id, 0, tempid.length);
			System.arraycopy( kb.getData(), 0, id, 0, kb.getData().length);
		}
		
		ArrayList<Object> idList = (ArrayList<Object>) Utility.revert( id );
		return idList;
	}
	
	/* Save an Identifier to the file
	* Requires getting all Identifiers,
	* appending new ID to list, then
	*   re-converting to byte[], splitting into 1kb blocks, and writing to file
	* NEEDS:
	* 		index (pointer from Field) - so class can rebuild all ID data from file; and
	*		the Identifier as an Object - no need for LFDatabase to convert this data,
	*		since Indexer is passing the ID as an Object (String, technically)
	*		and this class has to rebuild the ArrayList to add it already
	*/
	public void put( int startIndex, Object id ) throws IOException {
		// DO SOMETHING
		ArrayList<Object> idList = this.get( startIndex );
		idList.add( id );
		byte[] idData = Utility.convert( idList );
		
		// "clear" the data from file for writing new data
		// by freeing the indices in Allocate
		this.freePointers( startIndex );
		
		int start = 0;
		int index = Allocation.allocate( FILETYPE );
		int pointer = 0;
		
		do{
			// get info to create a 1kb block of data to write to file
			int size = Math.min( idData.length, MAXSIZE );
			byte[] kbData = new byte[size];
			System.arraycopy( idData, start, kbData, 0, size);
			
			// create new 1kb block
			if( size > MAXSIZE ){
				pointer = Allocation.allocate( FILETYPE );
			}
			else{
				pointer = 0;
			}
			Kblock kb = new Kblock( pointer, kbData );
			
			// Write Kblock to file
			DiskSpace.WriteArea( index, kbData, FILETYPE );
			// adjust index of ID array to point to next set of data
			start += size;
			index = pointer;
			
		} while( start < idData.length );
		
	}
	
	// Get all pointers in ID blocks of data, and free their space
	// via the Allocation ID bit array for rewriting
	private void freePointers( int index ) throws IOException {
		// DO SOMETHING
		int pointer = index;
		
		do{
			Allocation.free( pointer );
			Kblock kb = new Kblock( DiskSpace.ReadArea( pointer, FILETYPE ) );
			pointer = kb.getPointer();
		} while( pointer != 0 );
		
		
		
	}

}
