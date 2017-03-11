package com.minewhat.services;

import java.util.ArrayList;
import com.minewhat.module.Event;
import com.minewhat.serviceInterface.*;

public class ExecutionService implements ExecutionServiceInterface {
	ArrayList<Event> events = null;
	EventService eventService = null;
	
	public boolean eventExecuter(String fileSource,String date)  {
		if(fileSource == null){
			System.out.println("FileSource Cannot be Null");
			return false;
		}
		else{
			eventService = new EventService();
			events = new ArrayList<Event>();
			events = eventService.convertTextFiletoList(fileSource);
			events = eventService.sortEvents(events);
			events = eventService.sortEventbyPriority(events);
			if(eventService.compGvnWithFirstTime(events, date)){
				eventService.processQueue(events,date);
				return true;
			}
			
			return false;
		}
	}
}
