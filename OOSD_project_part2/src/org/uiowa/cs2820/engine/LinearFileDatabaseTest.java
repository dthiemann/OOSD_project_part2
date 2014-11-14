package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 * @author: Dylan Thiemann
 * 
 * Test file for LinearFileDatabase.java
 * 
 */

public class LinearFileDatabaseTest {
	
	@Before
	public void setUp() {
		// set up tests, if necessary
	}
	
	/*
	 * Tests retrieving a simple 
	 */
	@Test
	public void fetchTest() {
		LinearFileDatabase db = new LinearFileDatabase(true);
		String fieldKey = "myKey";
		String fieldValue = "myValue";
		
		String id = "file1.txt";
		
		Field f = new Field(fieldKey, fieldValue);
		byte[] byteArray = f.toBytes();
		
		Node origNode = new Node(byteArray, id);
		
		db.store(byteArray, id);
		
		Node newNode = db.fetch(byteArray);
		
		assert(origNode.equals(newNode));
	}
	
	/*
	 * Tests storing multiple identifiers
	 * for one field
	 */
	@Test
	public void multiStoreTest() {
		LinearFileDatabase db = new LinearFileDatabase(true);
		String fieldKey = "myKey";
		String fieldValue = "myValue";
		
		String id = "file1.txt";
		String id2 = "file2.txt";
		String id3 = "file3.txt";
		String id4 = "file4.txt";
		String id5 = "file5.txt";
		
		Field f = new Field(fieldKey, fieldValue);
		byte [] byteField = f.toBytes();
		
		/* Store all the id's for a specific field */
		db.store(byteField, id);
		db.store(byteField, id2);
		db.store(byteField, id3);
		db.store(byteField, id4);
		db.store(byteField, id5);
		
		/* Create a new Node to test the output */
		Node orig = new Node(byteField, id);
		orig.add(id2);
		orig.add(id3);
		orig.add(id4);
		orig.add(id5);
		
		/* Get our node back using db.fetch */
		Node newNode = db.fetch(byteField);
		
		assert(orig.equals(newNode));
	}
	
	/* Test accessing identifiers that don't exist */
	@Test
	public void testNullFetch() {
		
	}
	
	
}
