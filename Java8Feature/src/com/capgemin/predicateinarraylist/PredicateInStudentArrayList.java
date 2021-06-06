package com.capgemin.predicateinarraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInStudentArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> slist = new ArrayList<Student>();
		slist.add(new Student(1234,"Rama"));
		slist.add(new Student(1235,"Ramaji"));
		slist.add(new Student(1236,"Krishna"));
		
		List namesStartsWithR = filterByName(slist,(Student s)->s.getStudentName().startsWith("R"));
		System.out.println(namesStartsWithR);
	}

	private static List filterByName(List<Student> slist, Predicate<Student>pred) {
		// TODO Auto-generated method stub
		List<Student> resultList = new ArrayList<Student>();
		for(Student s:slist) {
			if(pred.test(s)) {
				resultList.add(s);
			}
		}
		return resultList;
	}

}
