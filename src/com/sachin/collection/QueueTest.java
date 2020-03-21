package com.sachin.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(20);
		q.add(1);
		q.forEach(System.out::println);
		q.poll();
		q.add(2);
		q.forEach(System.out::println);
	}

}
