package org.uiowa.cs2820.engine;

import java.io.IOException;

/*
 * @Author: Dylan Thiemann
 * 
 * A mock class for FieldStorage - used for testing while
 * the real class is still in production
 */

public class MockFieldStorage {

	public byte[] get( int index ) throws IOException {
		return null;
	}
	
	public int getPointer( byte[] f ) throws IOException {
		return 0;
	}
	
	public int getIndex( byte[] f ) throws IOException {
		return 0;
	}
	
	public void put( byte[] f ) throws IOException {
		
	}
}
