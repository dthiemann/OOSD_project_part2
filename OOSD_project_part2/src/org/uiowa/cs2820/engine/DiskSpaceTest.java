package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DiskSpaceTest {

	@Test
	public void test() throws IOException {
		String info = "Hello World";
		byte[] data = info.getBytes();
		DiskSpace.WriteArea(4,data,"ID");
		
		byte [] databack = DiskSpace.ReadArea(4,"ID");
		String infoback = new String(databack);
		System.out.println(infoback);
	assertEquals(info,infoback);
	//This sort of does work. The difference between info and infoback is that infoback has a crap ton of spaces.
	}

}
