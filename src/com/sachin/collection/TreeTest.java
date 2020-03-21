package com.sachin.collection;

import java.util.TreeSet;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<Integer> tree = new TreeSet<>();
		tree.add(20);
		tree.add(10);
		tree.add(5);
		tree.add(5);
		tree.add(1);
		tree.forEach(System.out::println);
		System.out.println(tree.pollFirst());
		System.out.println(tree.pollLast());
		tree.forEach(System.out::println);
		
	}

}
