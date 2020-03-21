package com.sachin.linkedlist;

public class DoubleLinkedList {
	
	static class Node{
		Node next;
		Node prev;
		int data;
		
		Node(int data){
			this.data = data;
			next= null;
			prev=null;
		}
	}
	
	static Node add(Node head, int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			return head;
		}
		Node curr= head;
		while(curr.next != null)
			curr = curr.next;
		
		newNode.prev = curr;
		curr.next=newNode;
		
		return head;
	}
	
	static Node addAfter(Node head, int k, int data) {
		Node curr;
		curr=head;
		Node newNode = new Node(data);
		
		if(head == null)
			return newNode;
		
		while(curr.next != null && curr.data != k) {
			curr=curr.next;
		}
		
		newNode.next = curr.next;
		newNode.prev = curr;
		curr.next = newNode;
		
		if(newNode.next != null)
			curr.next.prev = newNode;
		
		return head;
	}
	
	static void display(Node head) {
		Node curr;
		if(head==null) {
			System.out.println("Empty list");
		}
		
		curr=head;
		while(curr!= null) {
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
	}
	
	static Node delete(Node head,int k) {
		if(head == null)
			System.out.println("List is empty");
		Node temp, curr;
		temp=null;
		curr=head;
		
		if(curr.data == k) {
			head= curr.next;
			//curr.next = null;
			return head;
		}
		
		while(curr.next != null && curr.data != k) {
			curr= curr.next;
		}
		
		if(curr.next == null && curr.data==k) {
			temp = curr.prev;
			temp.next=null;
			return head;
		}
		
		temp = curr.prev;
		curr = curr.next;
		temp.next = curr;
		curr.prev = temp;
		
		return head;
	}
	
	

	public static void main(String arg[]) {
		Node head = null;
		
		head = add(head,10);
		head = add(head,20);
		head = add(head,30);
		head = add(head,40);
		head = add(head,50);
		display(head);	
	
		System.out.println("deleting the node");
		head = delete(head,40);
		display(head);
		
		System.out.println("add after the");
		head = addAfter(head, 30, 40);
		display(head);
	}
}
