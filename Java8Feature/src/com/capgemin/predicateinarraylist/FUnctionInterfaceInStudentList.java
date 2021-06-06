package com.capgemin.predicateinarraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FUnctionInterfaceInStudentList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> slist = new ArrayList<Student>();
		slist.add(new Student(1234,"Rama"));
		slist.add(new Student(1235,"Ramaji"));
		slist.add(new Student(1236,"Krishna"));
		Function<Student,String> funcStdToString = (Student s)->{return s.getStudentName();};
		Function<String,String> subStr = (String s)->s.substring(0,1);
		
		List<String> studentNameInitials = convertStudetnNameToNamesList(slist,funcStdToString.andThen(subStr));
		System.out.println("Student name initials=");
		//for each method in java 8
		studentNameInitials.forEach(str->{System.out.println(" "+str);});
	}//main close
	public static List<String> convertStudetnNameToNamesList(List<Student> slist,Function<Student,String>funcStdToString){
		List<String> studentNameList = new ArrayList<String>();
		for(Student s : slist) {
			studentNameList.add(funcStdToString.apply(s));
		}return studentNameList;
	}

}
