package com.sachin.linkedlist;

import com.sachin.linkedlist.LinkedList.Node;

public class LinkedListImplementaion {

	LinkedList list = new LinkedList();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListImplementaion linked = new LinkedListImplementaion();
		linked.print();
		linked.add(10);
		linked.add(20);
		linked.print();
		linked.addFront(30);
		linked.print();
		linked.delete(10);
		linked.delete(100);
		linked.print();
		linked.delete(20);
		linked.delete(30);
		linked.delete(4);
		linked.print();
		
		linked.add(10);
		linked.add(20);
		linked.add(30);
		linked.add(40);
		linked.deletePosition(1);
		linked.deletePosition(3);
		linked.print();
		
	}
	
	void add(int value) {
		Node newNode = new Node(value);
		
		if(list.head == null) {
			list.head = newNode;
		}else {
			
		Node last = list.head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		}
		System.out.println("Added" + value);
	}
	
	
	void print() {
		if(list.head == null) {
			System.out.println("List is empty");
		}else {
		Node temp = list.head;
		System.out.println("Printing list values");
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
		}
	}
	
	void addFront(int value) {
		Node newNode = new Node(value);
		newNode.next = list.head;
		list.head = newNode;
		System.out.println("Added at the front" + value);
	}
	
	boolean delete(int value) {
		if(list.head == null) {
			System.out.println("Empty list");
			return false;
		}
		
		Node prev = null;
		Node curr = list.head;
		
		//deleting first node
		if(curr != null && curr.value == value) {
			list.head = curr.next;
			System.out.println("Value found and deleted");
			return true;
		}
		
		// deleting in middle node
		while(curr != null && curr.value != value) {
			prev = curr;
			curr= curr.next;
		}
		
		//value not found condition
		if(curr == null) {
			System.out.println("value not found");
			return false;
		}else {
		prev.next = curr.next;
		System.out.println("Value found and deleted");
		return true;
		}
	}

	boolean deletePosition(int position) {
		if(list.head == null) {
			System.out.println("List is empty");
			return false;
		}
		Node curr = list.head;
		Node prev = null;
		if(position ==1) {
			System.out.println("deleted from first position");
			list.head = curr.next;
			return true;
		}
		int k=1;
		while(curr!= null && k != position) {
			prev = curr;
			curr= curr.next;
			k++;
		}
		
		if(curr == null || k > position) {
			System.out.println("Postion out of bound");
			return false;
		}else {
			prev.next = curr.next;
			System.out.println("deleted to particular postion");
			return true;
		}
	}
}
