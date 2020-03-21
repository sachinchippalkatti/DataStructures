package com.sachin.collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("sachin");
		pq.add("chippalkatti");
		pq.forEach(System.out::println);
		pq.poll();
		pq.add("anish");
		pq.forEach(System.out::println);
	}

}
