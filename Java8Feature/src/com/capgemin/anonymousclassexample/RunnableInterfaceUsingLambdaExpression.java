package com.capgemin.anonymousclassexample;

public class RunnableInterfaceUsingLambdaExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//implementation Runnable Interface Using Lambda expression
		Runnable runnable1 = ()->{
			System.out.println("run method using lambda expression");
			System.out.println("Run run");
		};
		
		Thread th = new Thread(runnable1);
		th.start();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		}

}
