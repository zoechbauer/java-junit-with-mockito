package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.internal.Assignments;

public class StringHelperTest {
	StringHelper stringHelper = new StringHelper();
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_noAinString() {
		assertEquals("CDEF", stringHelper.truncateAInFirst2Positions("CDEF"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinEndOfString() {
		assertEquals("CDAA", stringHelper.truncateAInFirst2Positions("CDAA"));
	}
}
