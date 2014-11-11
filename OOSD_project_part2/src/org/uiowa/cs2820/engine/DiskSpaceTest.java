package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import java.nio.charset.Charset;
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
		infoback = infoback.trim();
		//String infoback = new String(databack, 0, indexOfFirstNull, Charset.forName("US-ASCII"));
		System.out.println(infoback);
		assertEquals(info,infoback);
		//This sort of does work. The difference between info and infoback is that infoback has a crap ton of spaces.
	}

}
