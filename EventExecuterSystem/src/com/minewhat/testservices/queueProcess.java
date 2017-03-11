package com.minewhat.testservices;


import com.minewhat.services.ExecutionService;

public class queueProcess {

	public static void main(String[] args) {
//		System.out.println(args[0]+"---- "+args[1]+"----   "+ args[2]);
		
		String file =args[0]+args[1];
		String date= args[2];
		ExecutionService executionService = new ExecutionService();
		executionService.eventExecuter(file,date);
	}
}
