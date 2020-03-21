package com.sachin.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<>();
		ls.add("Sachin");
		ls.add("Swati");
		ls.add("Chotu");
		ls.add("lambu");
		
		//Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 10, Size: 1
		//System.out.println("index out of bound" + ls.get(10));
		
		List<String> linkedList = new LinkedList<String>();
		linkedList.add("sachin");
		linkedList.add("chippalkatti");
		linkedList.remove("sachin");
		linkedList.forEach(System.out::println);
		linkedList.stream().forEach(System.out::println);
		
		//Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 10, Size: 1
		//System.out.println("index out od bound" + linkedList.get(10));
		
		System.out.println("Before Listing Array");
		ls.stream()
		.forEach(System.out::println);
		
		System.out.println("Add the entry");
		ls.add("chippalkatti");
		ls.add(1,"kulkarni");
		
		System.out.println("Finding the list");
		String find = ls.stream()
			.filter(s->s.equals("Sachin"))
			.findFirst().get();
		System.out.println(find);
		ls = ls.stream().map(s->s.replaceFirst("Sachin", "Lumbo"))
					.collect(Collectors.toList());
		
		System.out.println("Delete from list");
		ls.remove("chippalkatti");
		
		System.out.println("After Listing Array");
		ls.stream()
		.forEach(System.out::println);
		
		System.out.println("5" + 5 + 5 + 100);
		System.out.println("5" + (5+5));
		System.out.println(5 - 5 + "5");
		System.out.println(5+5+5);
	}

}
