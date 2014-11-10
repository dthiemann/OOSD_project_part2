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
		String infoback = databack.toString();
		System.out.println(infoback);
		assertEquals(info,infoback);
	}

}
