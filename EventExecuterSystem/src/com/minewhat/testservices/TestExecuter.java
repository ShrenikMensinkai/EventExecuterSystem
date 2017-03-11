package com.minewhat.testservices;


import com.minewhat.services.ExecutionService;

public class TestExecuter {

	public static void main(String[] args) {
		String file = args[0];
		String date=args[1];
		ExecutionService executionService = new ExecutionService();
		executionService.eventExecuter(file,date);
	}
}
