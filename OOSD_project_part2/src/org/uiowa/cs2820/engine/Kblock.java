package org.uiowa.cs2820.engine;

import java.nio.ByteBuffer;
//import java.nio.IntBuffer;
import java.util.Arrays;

/*
 * Kblock class is used by FieldStorage and IdStorage to:
 *  + read the 1kb blocks of data from their respective files
 *  + create 1kb blocks of data to write to respective files
 *  
 *  NOTE: this is currently acting like my own internal "Node" class
 *  	  NEEDS TO BE TESTED (ByteBuffer get/put etc)
 *  
 */
public class Kblock {
	// Class variables
	private final int DATAINDEX = 8;
	private int pointer;
	private int size;
	private byte[] data;		
	
	// constructor 1
	// When given a 1kb block of data (read) from a file
	public Kblock( byte[] b ){
		// Get the ID pointer and Data size from byte array
		ByteBuffer bb = ByteBuffer.wrap( b );
		//IntBuffer ib = bb.asIntBuffer();  --- dont need??
		pointer = bb.getInt( 0 );
		size = bb.getInt( 1 );
		// Get the Data from the byte array
		data = Arrays.copyOfRange( b, DATAINDEX, size );
		
	}
	// constructor 2
	// When given a pointer and a byte array of data to write to a file
	public Kblock( int p, byte[] b ){
		this.pointer = p;
		size = b.length;
		data = Arrays.copyOf( b, b.length );
	}
	
	// internal methods
	public byte[] getBlock(){
		// FIND A WAY TO PUT ALL DATA INTO A 1KB BLOCK
		byte[] block = new byte[1000];
		ByteBuffer bb = ByteBuffer.wrap( block );
		bb.putInt( pointer );
		bb.putInt( size );
		bb.put( data );
		return block;
	}
	
	public int getPointer(){
		return pointer;
	}
	
	public byte[] getData(){
		return data;
	}
}
