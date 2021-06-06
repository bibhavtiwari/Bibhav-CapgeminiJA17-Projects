package com.capgemin.anonymousclassexample;

public class AnonymousClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Shape s = new Shape() {

	@Override
	void area() {
		// TODO Auto-generated method stub
		System.out.println("Shape Area");
	}
	
};
s.area();
 Vehicle v = new Vehicle() {

	@Override
	public void costOfVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Cost is this");
	}
	 
 };
 v.costOfVehicle();
	}

}
