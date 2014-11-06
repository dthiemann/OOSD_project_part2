package org.uiowa.cs2820.engine;


public class Checkpoint {
	
	static Database db;
	static String name;
	
	Checkpoint(Object O){
		name = O.toString();
		db = new LinearMemoryDatabase();
	}

	public static void save(Object O) {
		byte[] data = Field.convert(O);
		db.store(data, name);
	}

	public static Object restore(String bs_name) {
		return null;
	}

}

