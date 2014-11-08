package org.uiowa.cs2820.engine;

/*
 * Interface for FieldStorage and IdStorage classes 
 */

public interface FileStorage {
	// Will re-implement if can find way to return a generic
	// <E> byte[] get( E n );
	void put( byte[] n );
	void del( byte[] n );
	
	// probably don't need this method
	// void add( byte[] n );
	
}
