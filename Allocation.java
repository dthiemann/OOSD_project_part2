/*

------------------------------------------
        Allocation Class (Tim M)
------------------------------------------
Team 1 (Dylan T) (Jason S) (Joe M) (Tim M)  

*/

package org.uiowa.cs2820.engine;

import java.io.File;
import java.util.BitSet;

public class Allocation {

	private static BitSet bs;


	/**
	 * Returns a single free area in memory
	 */
	public static int allocate() {
		Checkpoint.save(bs);
		int freespace;
		if (bs.isEmpty()){
			freespace = 0;
		}
		else{
			freespace = bs.nextClearBit(0);
		}
		bs.set(freespace);
		Checkpoint.save(bs);
		return freespace;
	}
	
	public static int fs(){
		if (bs.isEmpty()){
			return 0;
		}
		else{
		    return bs.nextClearBit(0);
		}
	}

	public static void free(int areaNum) {
		bs.clear(areaNum);
		Checkpoint.save(bs);
		
	}

	public int size(){
		return bs.cardinality();
		
	}

public static void main(String [ ] args){
		try {
			File file = new File("a.txt");
			bs = (BitSet) Checkpoint.restore("a.txt");
			
			//FileOutputStream f = new FileOutputStream(file);
			
			if (!file.exists()){
				file.createNewFile();
			}
	}       catch(Exception e){}
}
}