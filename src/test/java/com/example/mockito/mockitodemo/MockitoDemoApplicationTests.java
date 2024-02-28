package com.example.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockitoDemoApplicationTests {
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;
	
	@Test
	void findGreatestOfAll_basicScenario() {
		when(dataServiceMock.retreiveAll()).thenReturn(new int[] {25,98,52});
		assertEquals(98, businessImpl.calculateGreatestOfAll());
	}
	
	@Test
	void findGreatestOfAll_OneValue() {
		when(dataServiceMock.retreiveAll()).thenReturn(new int[] {25});
		assertEquals(25, businessImpl.calculateGreatestOfAll());
	}
	
	@Test
	void findGreatestOfAll_EmptyArray() {
		when(dataServiceMock.retreiveAll()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.calculateGreatestOfAll());
	}

}
