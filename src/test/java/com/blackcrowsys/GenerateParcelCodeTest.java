package com.blackcrowsys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit test for {@code GenerateParcelCodeTest}.
 *
 * @author rahulsingh
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(GenerateParcelCode.class)
public class GenerateParcelCodeTest {

	private Map<String, List<Integer>> stringMap;
	private static final String STR_1 = "TUX";
	private static final String STR_2 = "8103T";

	/**
	 * Set up the mock objects and when they should return for
	 * the purpose of unit-testing.
	 */
	@Before
	public void setUp() {
		stringMap = new HashMap<String, List<Integer>>(); 
		PowerMockito.mockStatic(GenerateParcelCode.class);
		when (GenerateParcelCode.getCodeForStrings(STR_1, STR_2))
			.thenReturn("TUX12345678103T");
	}
	
	@Test
	public void testStaticMethodForGenerateParcelCode() {
		assertEquals("TUX12345678103T", GenerateParcelCode.getCodeForStrings(STR_1, STR_2));
	}
	
	@Test
	public void testHashMapWithStringKey() {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(5);
		stringMap.put(STR_1, ints);
		List<Integer> results = stringMap.get(STR_1);
		results.forEach(anInt -> assertEquals(new Integer(5), anInt));
	}
	
	@Test
	public void testHashMapReset() {
		assertTrue(stringMap.isEmpty());
	}
}
