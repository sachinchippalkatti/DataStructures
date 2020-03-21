package com.sachin.collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(1);
		set.add(2);
		set.add(20);
		set.add(10);
		System.out.println("duplicate");
		set.forEach(System.out::println);
	}

}
