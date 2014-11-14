package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;
/*
 * @Author: Dylan Thiemann
 * 
 * A mock class for FieldStorage - used for testing while
 * the real class is still in production
 */

public class MockIdStorage {
	HashMap<byte[], ArrayList<String>> myMap;
	
	public MockIdStorage() {
		this.myMap = new HashMap<byte[], ArrayList<String>>();
	}
	
	public ArrayList<Object> get( int index ) throws IOException {
		return null;
	}
	
	public void put( int startIndex, Object id ) throws IOException {
		
	}
}
