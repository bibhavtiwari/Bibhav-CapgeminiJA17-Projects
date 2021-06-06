package com.capgemin.lambdaexpressionexample;
@FunctionalInterface
public interface Substraction {
 public float sub();
 default void readValues() {
	 System.out.println("REad Values");
 }
 static void display() {
	 System.out.println("display values");
 }
}
