package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

/*
 * @Author: Dylan Thiemann
 * 
 * A mock class for FieldStorage - used for testing while
 * the real class is still in production
 */

public class MockIdStorage extends IdStorage {
	/* 
	 * Using a hashmap for testing purposes - 
	 * as opposed to an actual file
	 */
	HashMap<Integer, ArrayList<Object>> myMap;
	
	public MockIdStorage() {
		this.myMap = new HashMap<Integer, ArrayList<Object>>();
	}
	
	@Override
	public ArrayList<Object> get( int index ) throws IOException {
		/* return the identifiers if they exist, else return null */
		if (this.myMap.containsKey(index)) {
			return this.myMap.get(index);
		}
		return null;
	}
	
	@Override
	public void put( int startIndex, Object id ) throws IOException {
		ArrayList<Object> identifiers;
		/* if the array already exists, add it */
		if (this.myMap.containsKey(startIndex)) {
			identifiers = this.myMap.get(startIndex);
			identifiers.add(id);
		/* else, create a new array and add it */
		} else {
			identifiers = new ArrayList<Object>();
			identifiers.add(id);
		}
		
		/* store the identifiers back in the hashmap */
		this.myMap.put(startIndex, identifiers);
	}
}
