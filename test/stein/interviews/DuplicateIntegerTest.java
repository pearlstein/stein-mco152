package stein.interviews;

import static org.junit.Assert.*;

import org.junit.Test;

public class DuplicateIntegerTest {

	DuplicateInteger x=new DuplicateInteger();

	@Test
	public void test() {
		int[] array=new int[12];
		
		array[0]=1;
		array[1]=2;
		array[2]=2;
		array[3]=3;
		array[4]=4;
		array[5]=5;
		array[6]=6;
		array[7]=7;
		array[8]=8;
		array[9]=9;
		array[10]=10;
		array[11]=11;
		
		assertEquals(x.findDuplicate(array),2);
		
		array[0]=1;
		array[1]=2;
		array[2]=3;
		array[3]=4;
		array[4]=4;
		array[5]=5;
		array[6]=6;
		array[7]=7;
		array[8]=8;
		array[9]=9;
		array[10]=10;
		array[11]=11;
		
		assertEquals(x.findDuplicate(array),4);
		
		array[0]=1;
		array[1]=2;
		array[2]=3;
		array[3]=4;
		array[4]=5;
		array[5]=6;
		array[6]=7;
		array[7]=7;
		array[8]=8;
		array[9]=9;
		array[10]=10;
		array[11]=11;
		
		assertEquals(x.findDuplicate(array),7);
		
		array[0]=1;
		array[1]=2;
		array[2]=3;
		array[3]=4;
		array[4]=5;
		array[5]=6;
		array[6]=7;
		array[7]=8;
		array[8]=9;
		array[9]=9;
		array[10]=10;
		array[11]=11;
		
		assertEquals(x.findDuplicate(array),9);
		assertFalse(x.findDuplicate(array)==10);
		
		array[0]=1;
		array[1]=2;
		array[2]=3;
		array[3]=4;
		array[4]=5;
		array[5]=6;
		array[6]=7;
		array[7]=8;
		array[8]=9;
		array[9]=10;
		array[10]=11;
		array[11]=11;
		
		assertEquals(x.findDuplicate(array),11);
	}

}
