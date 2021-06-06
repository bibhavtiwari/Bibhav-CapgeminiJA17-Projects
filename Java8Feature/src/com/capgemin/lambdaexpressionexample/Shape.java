package com.capgemin.lambdaexpressionexample;

public interface Shape {

	 public void area();
	 public void perimeter();
	 
	 default void readLength() {
		 System.out.println("reading 1");
	 }
	 default void readBreadth() {
		 System.out.println("reading 2");
	 }
	 static void display() {
		 System.out.println("display Shape details");
	 }
}
