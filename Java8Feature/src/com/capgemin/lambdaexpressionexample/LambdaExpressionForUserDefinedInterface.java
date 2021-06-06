package com.capgemin.lambdaexpressionexample;

import java.util.function.Predicate;

public class LambdaExpressionForUserDefinedInterface {

	public static void main(String...args) {
		// TODO Auto-generated method stub
		Addition ad = ()->{
			System.out.println("Addition of two number"+(9+6));
		};
		ad.add();
		int a = 10;
		int b = 56;
		Multiplication mul = ()->{
			int c = a*b;
			System.out.println("Multiplication of two number is "+c);
		};
		mul.mul();
	//Lambda Expression with return type
		Substraction sb = ()-> {return(65-8);};
		float result = sb.sub();
		System.out.println("Substraction of two number is"+ result);
		sb.readValues();
		Substraction.display();
		//Lambda with return type and one parameter
		Message mg = (String m)->{
			return m+"Hello Lambda";
		};
		String returnmsg = mg.printMessage("Hoi");
		System.out.println(returnmsg);
	//lambda without return type and two para meter
		Division div =(  r , n)->{
			System.out.println("Division of two numbe ris "+(r/n));
		}; div.printdivide(40, 10);
		//Lambda expression for predicate interface in java.util function package
		Predicate<Float> lesser1 = age->(age>18);
		System.out.println(lesser1.test(20.0f));
		Predicate<Integer> greater = age->(age>18);
		//calling predicate method
		System.out.println(greater.test(20));
		Predicate<Integer> lesser = age->(age<18);
		//calling predicate method
		System.out.println(lesser.test(20));
		boolean checkAge = greater.and(lesser).negate().test(25);
		System.out.println(checkAge);
		boolean checkAge1 = greater.or(lesser).test(25);
		System.out.println(checkAge1);
		//calling a method with predicate as parameter
		predicateInMethod(14,age->(age<18));
	}//close main function
	//Predicate in to method param
	static void predicateInMethod(int number, Predicate<Integer>age) {
		if(age.test(number)) {
			System.out.println("age satisfied "+number);
		}else {
			System.out.println("age not satisfied="+number);
		}
	}

}
