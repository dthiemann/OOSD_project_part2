package org.uiowa.cs2820.engine;

import java.util.BitSet;

public class Allocation {

	static String bs_name;

	Allocation() {
		BitSet bs = new BitSet();
		bs_name = bs.toString();
		Checkpoint.save(bs);
	}

	/**
	 * Returns a single free area in memory
	 */
	public static int allocate() {
		BitSet bs = (BitSet) Checkpoint.restore(bs_name);
		int m = bs.nextClearBit(0);
		bs.set(m);
		Checkpoint.save(bs);
		return m;
	}

	public static void free(int areaNum) {
		BitSet bs = (BitSet) Checkpoint.restore(bs_name);
		bs.clear(areaNum);
	}
}

