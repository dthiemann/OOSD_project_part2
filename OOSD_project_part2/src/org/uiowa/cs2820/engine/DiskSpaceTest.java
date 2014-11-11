package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
//Written by Jason Sherman

import java.io.IOException;

import org.junit.Test;

public class DiskSpaceTest {

	@Test
	public void test() throws IOException {
		String info = "Hello World! Huzzah!";
		byte[] data = info.getBytes();
		DiskSpace.WriteArea(0,data,"ID");
		
		byte [] databack = DiskSpace.ReadArea(0,"ID");
		String infoback = new String(databack);
		System.out.println(infoback);
		assertEquals(info,infoback);
		//This sort of does work. The difference between info and infoback is that infoback has a crap ton of spaces.
	}

}
