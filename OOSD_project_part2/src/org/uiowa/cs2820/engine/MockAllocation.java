package org.uiowa.cs2820.engine;

public class MockAllocation {
	private static int[] bitField = {0};
	private static int[] bitIDs = {0};
	
	public static int allocate(String filename){
		int[] bits = getFile(filename);
		for(int i = 1; i < bits.length; i++){
			if( bits[i] == 0){
				bits[i] = 1;
				return i;
			}
		}
		// If all bits set, expand array
		expandBits(bits);
		return allocate(filename);
	}
	
	public static int fs(String filename){
		int[] bits = getFile(filename);
		for(int i = 1; i < bits.length; i++){
			if( bits[i] == 0){
				return i;
			}
		}
		// If all bits set, expand array
		expandBits(bits);
		return allocate(filename);
	}
	
	public static void free(String filename, int index){
		int[] bits = getFile(filename);
		bits[index] = 0;
	}
	
	public static int size(String filename){
		int[] bits = getFile(filename);
		return bits.length;
	}
	
	// Determine which array to read/write from
	private static int[] getFile(String filename){
		if( filename == "FIELD"){
			return bitField;
		}
		else{
			return bitIDs;
		}
	}
	
	// Increase size of array
	private static void expandBits(int[] bits){
		int[] newBits = new int[bits.length * 2];
		System.arraycopy(bits, 0, newBits, 0, bits.length);
		bits = newBits;
	}
	
}
