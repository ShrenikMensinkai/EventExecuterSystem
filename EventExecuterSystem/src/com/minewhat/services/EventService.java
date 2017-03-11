package com.minewhat.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.minewhat.module.Event;

import com.minewhat.serviceInterface.EventServiceExecuterInterface;

public class EventService implements EventServiceExecuterInterface {
	
	FileInputStream fileInput = null;
	BufferedReader bufferedReader = null;
	DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss"); 
		
	public ArrayList<Event> sortEvents(ArrayList<Event> events) {
		for(int i=0;i<events.size();i++){
			for(int j=0;j<events.size()-1;j++){
				if(events.get(j).getDate().after(events.get(j+1).getDate())){
					events= swapOrders(events,j,j+1);
				}
			}
		}return events;
	}
	
	
	public void processQueue(ArrayList<Event> events,String gdate){
		
		int length = events.size(),count=0;
		
		try {
			Date date = inputFormat.parse(gdate);
			System.out.println(date);
			if((events.get(length-1).getDate().after(date)||events.get(length-1).getDate().equals(date))){
				
				while(count<length){
					Date sdate = new Date();
					if(events.get(count).getDate().equals(sdate)){
							System.out.println(dateDisplay(sdate,events.get(count)));
							count++;
						}
					}
			}
			System.out.println("Given Date is Greater then least task Date");
		} catch (ParseException e) {
			System.out.println("Given date is invalid");
			
			e.printStackTrace();
		}
			
	}
	public String dateDisplay(Date date, Event event){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return "Current time ["+cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH) + 1)+"/"+cal.get(Calendar.DATE)+"  "+"" +", Event "+event.getEventName()+" Processed";
	}
	
	
	public ArrayList<Event> sortEventbyPriority(ArrayList<Event> events){
		for(int i=0;i<events.size();i++){
			for(int j=0;j<events.size()-1;j++){
				if((events.get(i).getDate().equals(events.get(j).getDate()))&&(events.get(i).getPriority()>events.get(j).getPriority())){
					events= swapOrders(events,j,i);
				}
			}
		}return events;
	}
	
	
	public boolean isEvtWithSameDatePrty(ArrayList<Event> events){
		for(int i=0;i<events.size();i++){
			for(int j=0;j<events.size()-1;j++){
				if((events.get(i).getDate()==events.get(j).getDate())&&(events.get(i).getPriority()==events.get(j).getPriority())){
					return false;
				}
			}
		}return true;
	}
	
	
	
	public ArrayList<Event> swapOrders(ArrayList<Event> events, int eventIndexI, int eventIndexJ) {
		Event temp1=null,temp2=null;
		temp1=events.get(eventIndexI);
		temp2=events.get(eventIndexJ);
		events.set(eventIndexI, temp2);
		events.set(eventIndexJ, temp1);
		return events;
	}
	
	
	public boolean compGvnWithFirstTime(ArrayList<Event> events, String date){
		try {
				Date tempDate=inputFormat.parse(date);
				if((events.get(0).getDate().equals(tempDate)||events.get(0).getDate().after(tempDate))){
					return true;
				}						
		} catch (ParseException e) {
			System.out.println("Invalid Input Date");
			e.printStackTrace();
		}	
		System.out.println("File Contain older Events then the given Time");
		return false;
	}
	
	
	
	
	
	
	
	
	public ArrayList<Event> convertTextFiletoList(String fileSource){
		ArrayList<Event> events = new ArrayList<Event>();
		try{
			fileInput = new FileInputStream(fileSource);
			bufferedReader = new BufferedReader(new InputStreamReader(fileInput));
			String line = bufferedReader.readLine();
			line = bufferedReader.readLine();
			while (line != null){	
				Event newEvent = new Event();
				String[] param = line.split(",");
				newEvent.setEventName(param[0]);
				newEvent.setDate(inputFormat.parse(param[1]));
				if(param.length == 3){
					newEvent.setPriority(Long.parseLong(param[2]));
				}
				events.add(newEvent);
				line = bufferedReader.readLine();
			}
		}
		catch(NumberFormatException n){
			System.out.println(n);
		}catch(IOException io){
			System.out.println(io);
		}catch (ParseException d) {
			System.out.println(d);
				}	
		finally{
				try{
					if(bufferedReader!=null)
						bufferedReader.close();
					if(fileInput!=null)
						fileInput.close();
				} 
				catch (IOException e){
					System.out.println(e);
				}
			}return events;
		}
}

