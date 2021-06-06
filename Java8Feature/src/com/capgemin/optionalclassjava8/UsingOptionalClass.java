package com.capgemin.optionalclassjava8;

import java.util.Optional;

public class UsingOptionalClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = new String[10];
		Optional<String>isNull = Optional.ofNullable(str[9]);
		if(isNull.isPresent()) {
			//extracting substring from a string
			String subStr = str[9].substring(2,5);
			System.out.println(subStr);
		}else {
			System.out.println("empty string");
		}
	str[9] = "This is a string";
	Optional<String>isNull1 = Optional.ofNullable(str[9]);
	isNull1.ifPresent(s->System.out.println(s.substring(2,5)));
	
	}

}
