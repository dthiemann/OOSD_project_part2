package org.uiowa.cs2820.engine;

/*
 * Interface for FieldStorage and IdStorage classes 
 */

public interface FileStorage {
	<E> byte[] get( E n );
	void put( byte[] n );
	void del( byte[] n );
	
	// probably don't need this method
	// void add( byte[] n );
	
}
