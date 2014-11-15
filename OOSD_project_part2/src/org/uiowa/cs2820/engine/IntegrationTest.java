package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.io.IOException;

//I (Jason Sherman) was going to write this but FieldTest already does an adequate Integration tests and runs the tests
//that i was planning to run.

// ** FieldTest is not a comprehensive Integration Test. Added 2 test cases for verification.

public class IntegrationTest {
//User uses: Indexer, Field, FieldSearch
	//Create a field with a key value pair, with an identifier, send to indexer (add to database).
	//Add some other random field,identifier to database.
	//Add another field that is identical to first field with a different identifier.
	//(We are searching for fields, returning identifiers)
	
	// Adds Fields to file and tests FieldSearches on them
	@Test
	public void testFinds() {
		Database db = new LinearFileDatabase();
		
		Field f1 = new Field("key1","value1");
		Field f2 = new Field("key2","value2");
		Field f3 = new Field("key3","value3");

		String id1 = "1st identifier";
		String id2 = "2nd identifier";
		String id3 = "3rd identifier";

		Indexer index1 = new Indexer(db, id1);
		index1.addField(f1);
		index1.addField(f2);
		index1.addField(f3);
		
		Indexer index2 = new Indexer(db, id2);
		index2.addField(f1);
		index2.addField(f3);
		
		Indexer index3 = new Indexer(db, id3);
		index3.addField(f2);
		index3.addField(f3);
		
		FieldSearch fs = new FieldSearch(db);
		ArrayList<String> array1 = new ArrayList<String>();
		array1.add(id1);
		array1.add(id2);
		ArrayList<String> array2 = new ArrayList<String>();
		array2.add(id1);
		array2.add(id3);
		ArrayList<String> array3 = new ArrayList<String>();
		array3.add(id1);
		array3.add(id2);
		array3.add(id3);
		
		assertArrayEquals( array1.toArray(), fs.findEquals(f1) );
		assertArrayEquals( array2.toArray(), fs.findEquals(f2) );
		assertArrayEquals( array3.toArray(), fs.findEquals(f3) );
	}

	// Adds Fields to file and tests FieldSearches on them
	@Test(expected = IOException.class)
	public void testFails() {
		Database db = new LinearFileDatabase();
		
		Field f4 = new Field("key4","value1");
		Field f5 = new Field("key5","value2");

		String id = "4th identifier";

		Indexer index1 = new Indexer(db, id);
		index1.addField(f4);
		
		FieldSearch fs = new FieldSearch(db);
		
		assertArrayEquals( new String[0], fs.findEquals(f5) );
	}
}
