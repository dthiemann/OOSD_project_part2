package org.uiowa.cs2820.engine;

/*
 * Interface for FieldStorage and IdStorage classes 
 */

public interface FileStorage {
	byte[] get( int n );
	void put( byte[] n );
	
	// probably don't need this method
	// void add( byte[] n );
	
}
