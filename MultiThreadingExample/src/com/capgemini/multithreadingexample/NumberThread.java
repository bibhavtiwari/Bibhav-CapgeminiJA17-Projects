package com.capgemini.multithreadingexample;

public class NumberThread implements Runnable {
	String tname;
	Thread t,t1;
	public NumberThread(String threadName) {
		tname = threadName;
		t = new Thread(this,threadName);
		t.setPriority(1);
		t.start();
		t1 = new Thread();
		t1.setName("Rama");
		t1.setPriority(6);
		t1.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
	}
	public static void main(String[]args) {
		new NumberThread("Krishna");
		System.out.println("in main method");
	}

}
