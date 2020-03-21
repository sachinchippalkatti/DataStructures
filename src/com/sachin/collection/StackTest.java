package com.sachin.collection;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.add(10);
		stack.add(20);
		stack.add(22);
		
		stack.pop();
		stack.peek();
		stack.contains(10);
		stack.isEmpty();
		stack.stream().forEach(System.out::println);
		
		Vector<Integer> vector = new Vector<>();
		vector.add(10);
		vector.add(10);
		vector.add(20);
		vector.add(30);
		
		vector.remove(2);
		vector.contains(10);
		vector.isEmpty();
		vector.firstElement();
		vector.stream().forEach(System.out::println);
	}

}
