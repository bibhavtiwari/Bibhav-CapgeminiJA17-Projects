package com.capgemin.streamapi;

import java.util.ArrayList;
import java.util.List;

public class STreamAPIExample {

	public static List<String> getPlaces() {
		// TODO Auto-generated method stub
		List<String> countriesPlaces = new ArrayList<String>();
		//list of countries
		countriesPlaces.add("Nepal,Kathmandu");
		countriesPlaces.add("Orissa,Puri");
		countriesPlaces.add("SriLanka,Colombo");
		countriesPlaces.add("India , New Delhi");
		countriesPlaces.add("WestBengal , Kolkata");
		
		return countriesPlaces;
		
	}
	public static void main(String[]args)
	{
		List<String> area = getPlaces();
		System.out.println("Places from Orissa");
		area.stream().filter((p)->p.startsWith("Orissa"))
		.map((p)->p.toUpperCase())
		.sorted()
		.forEach((p)->System.out.println(p));
		
		long count = area.stream().filter((s)->s.endsWith("a")).count();
		System.out.println(count);
		
		
		
		
		
	}
}








