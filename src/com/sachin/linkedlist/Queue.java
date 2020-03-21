package com.sachin.linkedlist;

public class Queue {
	Node rear, front;
	
	static class Node{
		int value;
		Node next;
		
		Node(int value){
			this.value=value;
			next=null;
		}
	}
	
	void enQueue(int value) {
		Node newNode = new Node(value);
		if(rear == null) {
			rear =newNode;
			front=newNode;
		}else {
			rear.next = newNode;
			rear=newNode;
		}
	}
	
	void qeQueue() {
		if(front == null)
			System.out.println("queue is empty");
		else {
			Node temp = front;
			front = front.next;
		}
		if(front == null)
			rear = null;
	}
	void display() {
		if(rear ==null) {
			System.out.println("queue is empty");
		}else {
			Node curr=front;
			 do{
				System.out.print(curr.value + "->");
				curr=curr.next;
			}while(curr != null);
		}
	}
	public static void main(String arg[]) {
		Queue queue= new Queue();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.display();
		queue.qeQueue();
		queue.display();
	}
}
