/*

------------------------------------------
        Allocation Class (Tim M)
------------------------------------------
Team 1 (Dylan T) (Jason S) (Joe M) (Tim M)  

*/

package org.uiowa.cs2820.engine;

import java.util.BitSet;

public class Allocation {

	private static BitSet bs;

	/*
	 Returns a single free area in memory
	*/
	public static int allocate(String param) throws Exception {
		bs = Checkpoint.restore(param);
		Checkpoint.save(bs, param);
		int freespace;
		if (bs.isEmpty()){
			freespace = 0;
		}
		else{
			freespace = bs.nextClearBit(1);
		}
		bs.set(freespace);
		Checkpoint.save(bs, param);
		return freespace;
	}
	
	/*
	 returns index of free slot 
	 in ID BitArray w/o calling allocate()
	*/
	public static int fs() throws Exception{
		bs = Checkpoint.restore("ID");
		if (bs.isEmpty()){
			return 0;
		}
		else{
		    return bs.nextClearBit(1);
		}
	}

	//frees up areaNum
	public static void free(int areaNum, String param) throws Exception {
		bs = Checkpoint.restore(param);
		bs.clear(areaNum);
		Checkpoint.save(bs, param);
	}

	public int size() throws Exception{
		bs = Checkpoint.restore("FIELD");
		return bs.length();
	}		
}
/*
public static void main(String [ ] args){
		try {
			File file = new File("a.txt");
			bs = (BitSet) Checkpoint.restore("a.txt");
			
			if (!file.exists()){
				file.createNewFile();
			}
	}       catch(Exception e){}
} */