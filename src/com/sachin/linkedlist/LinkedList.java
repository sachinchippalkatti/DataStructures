package com.sachin.linkedlist;

public class LinkedList {

	Node head;
	
	static class Node{
		int value;
		Node next;
		
		Node(int value){
			this.value = value;
			this.next = null;
		}
	}
}
