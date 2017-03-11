package com.minewhat.serviceInterface;

import java.util.ArrayList;

import com.minewhat.module.Event;

public interface EventServiceExecuterInterface {
	
	public ArrayList<Event> sortEvents(ArrayList<Event> events);
	public void processQueue(ArrayList<Event> events,String date);
	public ArrayList<Event> sortEventbyPriority(ArrayList<Event> events);
	public boolean isEvtWithSameDatePrty(ArrayList<Event> events);
	public ArrayList<Event> swapOrders(ArrayList<Event> events, int eventIndexI, int eventIndexJ);
	public boolean compGvnWithFirstTime(ArrayList<Event> events, String date);
	public ArrayList<Event> convertTextFiletoList(String fileSource);
	

}
