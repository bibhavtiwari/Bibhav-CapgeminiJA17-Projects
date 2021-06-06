package com.capgemin.optionalclassjava8;

import java.util.Optional;

public class OptionalClassExample {

	public static void main(String[] args) throws StringNotFoundException {
		// TODO Auto-generated method stub
		String[]str = new String[10];
		str[9]="This is a String";
		Optional<String>emptyOp = Optional.empty();
		System.out.println(emptyOp);
		Optional<String> values = Optional.of(str[9]);
		System.out.println(values);
		System.out.println("Filtered values: "+values.filter((s)->s.equals("xyz")));
		System.out.println("Filtered values: "+values.filter((s)->s.equals("This is a String")));
		System.out.println(values.get());
		System.out.println("Hashcode of Valyue="+ values.hashCode());
		System.out.println("Hashcode of Valyue="+ values.isPresent());
		System.out.println("Nullable in optional class = "+Optional.ofNullable(emptyOp));
		System.out.println("Nullable in optional clas  = "+Optional.ofNullable(values));
		System.out.println("orElse in optional class = "+ values.orElse("Value is not present"));
		System.out.println("orElse in optional class = "+ values.orElseThrow(()->new StringNotFoundException("String is empty")));
		System.out.println("orElse in optional class = "+ emptyOp.orElseThrow(()->new StringNotFoundException("String is empty")));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
