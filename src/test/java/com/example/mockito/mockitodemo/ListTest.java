package com.example.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {
	
	List listMock = mock(List.class);

	@Test
	void simpleTest() {
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
	}
	
	@Test
	void multipleParameters() {
		when(listMock.size()).thenReturn(3).thenReturn(2);
		assertEquals(3, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}
	
	@Test
	void specificParameters() {
		when(listMock.get(0)).thenReturn("some string");
		assertEquals("some string", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	void genericParameters() {
		when(listMock.get(Mockito.anyInt())).thenReturn("some string");
		assertEquals("some string", listMock.get(0));
		assertEquals("some string", listMock.get(1));
	}

}
