package com.minewhat.testservices;


import com.minewhat.services.ExecutionService;

public class TestExecuter {

	public static void main(String[] args) {
		String file = "C:\\minewhat\\new.csv";
		String date="3/11/2017 9:40:00";
		ExecutionService executionService = new ExecutionService();
		executionService.eventExecuter(file,date);
		
	}

}
