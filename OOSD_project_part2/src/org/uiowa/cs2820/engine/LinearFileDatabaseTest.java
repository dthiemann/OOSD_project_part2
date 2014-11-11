package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class LinearFileDatabaseTest {
	
	@Before
	public void setUp() {
		// set up tests, if necessary
	}
	
	@Test
	public void fetchTest() {
		LinearFileDatabase db = new LinearFileDatabase();
		String fieldKey = "myKey";
		String fieldValue = "myValue";
		
		String id = "file1.txt";
		
		Field f = new Field(fieldKey, fieldValue);
		byte[] byteArray = f.toBytes();
		
		db.store(byteArray, id);
		
		db.fetch(byteArray);
		
		assertEquals(0,0);
	}
	
	
	
	
}
