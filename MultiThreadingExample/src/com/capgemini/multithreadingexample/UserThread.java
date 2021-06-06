package com.capgemini.multithreadingexample;

public class UserThread extends Thread {
//to assign a action/task to a thread
	public void run() {
		System.out.println("Thread is in running State");
		for(int i =0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			}catch(Exception e) {
			System.out.println(e);}
		
		System.out.println(i);
	}}
	public static void main(String[] args) throws InterruptedException {
		UserThread ut = new UserThread();
		ut.setName("Rama");//set the thread name
		ut.start();// thread 0
		try {
			ut.join();
			System.out.println("Name ="+ut.getId());
			System.out.println("Name ="+ut.getName());
		}catch(Exception e) {
			System.out.println(e);
		}
		UserThread ut1 = new UserThread();
		ut1.start();//thread 1
		System.out.println("Name ="+ut1.getId());
		System.out.println("Name ="+ut1.getName());
		UserThread ut2 = new UserThread();
		ut2.start();//thread 2
		System.out.println("Name ="+ut2.getId());
		System.out.println("Name ="+ut2.getName());
	}
}
