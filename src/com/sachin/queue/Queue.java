package com.sachin.queue;

public class Queue {
	
	public Node head;
	public Node tail;
	
	public static class Node<T>{
		T value;
		Node next;
		
		Node(T value){
			this.value = value;
			this.next=null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.head = null;
		q.tail = null;
		q.add(10);
		q.add(30);
		q.add(220);
		q.add(222);
		q.add(300);
		q.dequeue();
		q.print();
	}

	private void print() {
		// TODO Auto-generated method stub
		if(head==null) {
			System.out.println("Queue is empty");
			return;
		}
		Node current = head;
		while(current!=null) {
			System.out.println(current.value);
			current = current.next;
		}
	}

	private void add(Integer value) {
		// TODO Auto-generated method stub
		Node<Integer> newnode = new Node<Integer>(value);
		if(head==null) {
			head = newnode;
			tail = newnode;
			return;
		}
		tail.next = newnode;
		tail = newnode;
	}
	
	private void dequeue() {
		if(head==null) {
			return;
		}
		head = head.next;
	}
	
	

}
