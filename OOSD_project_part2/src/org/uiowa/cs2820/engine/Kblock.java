package org.uiowa.cs2820.engine;

import java.nio.ByteBuffer;

/**
 * Joe Maule
 * CS:2820, Fall 2014
 *
 * Purpose:
 * 	This class is used by FieldStorage and IdStorage to:
 * 	  + read the 1kb blocks of data from their respective files
 *    + create 1kb blocks of data to write to their respective files
 *    
 * Format of 1kb blocks:
 * 	  [ pointer | size | data | (empty space) ]
 */

public class Kblock {
	// Class variables
	private int pointer;
	private int size;
	private byte[] data;		
	
	// Constructor 1: When given a 1kb block of data read from a file
	public Kblock( byte[] b ){
		// Get the ID pointer and data size from byte array
		ByteBuffer bb = ByteBuffer.wrap( b );
		pointer = bb.getInt();
		size = bb.getInt();
		// Get the data from the byte array
		data = new byte[size];
		bb.get(data);
	}
	
	// Constructor 2: When given a pointer and byte array of data to write to a file
	public Kblock( int p, byte[] b ){
		// Set local variables
		pointer = p;
		size = b.length;
		data = b;
	}
	
	// Create a 1kb byte array of data to write to a file
	public byte[] getBlock(){
		// Create a byte array to store data
		byte[] block = new byte[1024];
		// Add data to byte array and return it
		ByteBuffer bb = ByteBuffer.wrap( block );
		bb.putInt( pointer );
		bb.putInt( size );
		bb.put( data );
		return block;
	}
	
	/** Get() Methods */
	public int getPointer(){ return pointer; }
	public byte[] getData(){ return data; }

}
