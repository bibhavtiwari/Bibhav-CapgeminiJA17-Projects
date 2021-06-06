package com.capgemin.anonymousclassexample;

public class RunnableInterfaceUsingAnonymousClass {
	public static void main(String[]args) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Run method in anonymous class");
			}
		}).start();
	}

	
}
