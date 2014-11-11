package org.uiowa.cs2820.engine;

import java.util.*;
/*
 * Interface for FieldStorage and IdStorage classes 
 */

public interface FileStorage {
	ArrayList<Object> get( int n );
	void put( byte[] n );
	
	// probably don't need this method
	// void add( byte[] n );
	
}
