package com.minewhat.testservices;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.minewhat.module.Event;

public class testeventnew {
	
	
	public static ArrayList<Event> convertTextFiletoList(String fileSource){
		ArrayList<Event> tempEvents = new ArrayList<Event>();
		BufferedReader bufferedReader = null;
		try{
			DateFormat inputFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			FileInputStream fileInput = new FileInputStream(fileSource);
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
				tempEvents.add(newEvent);
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
			} 
			catch (IOException e) {
				System.out.println(e);
				}
		}return tempEvents;
	}
	public static void main(String[] args) throws InterruptedException{
//		ArrayList<Event> temp = convertTextFiletoList("C:\\minewhat\\abc.csv");
//		//System.out.println(temp);
//		for (Event event : temp) {
//			System.out.println(event.getEventName()+" "+event.getDate()+" "+event.getPriority());
//		}
//	
//		

		Date date = new Date();
		Thread.sleep(1000);
		Date date1 = new Date();
		System.out.println(date +"   " + date1);
		if(date.before(date1))
		System.out.println("yes");
		else System.out.println("no");
	}
	
	

}
