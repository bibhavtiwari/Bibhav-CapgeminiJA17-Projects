package com.capgemini.multithreadingexample;

public class GCExample {
	public void finalize() {
		System.out.println("Finalize method is called to make this object GC eligible");
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo d = new Demo();
		d = null;
		System.gc();
		
				
	}

}
