package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.*;

/*
 * @Author: Dylan Thiemann
 * 
 * A mock class for FieldStorage - used for testing while
 * the real class is still in production
 */

public class MockFieldStorage {
	ArrayList<Integer> keyArray;
	HashMap<byte[], Integer> keyHash;
	HashMap<Integer, byte[]> integerHash;
	int currentNum;
	
	public MockFieldStorage() {
		this.keyArray = new ArrayList<Integer>();
		this.keyHash = new HashMap<byte[], Integer>();
		this.integerHash = new HashMap<Integer, byte[]>();
		this.currentNum = 0;
	}

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
