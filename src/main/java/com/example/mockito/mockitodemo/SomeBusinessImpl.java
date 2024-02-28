package com.example.mockito.mockitodemo;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeBusinessImpl {
	
	@Autowired
	private DataService dataService;
	
	public int calculateGreatestOfAll() {
		int[] data = dataService.retreiveAll();
		int greatestValue = Integer.MIN_VALUE;
		for (int value : data) {
			if (value > greatestValue) {
				greatestValue = value;
			}
		}
		return greatestValue;
	}

}

interface DataService {
	int[] retreiveAll();
}
