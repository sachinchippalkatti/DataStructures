package com.sachin.linkedlist;

public class Tree {
	Node root;
	
	static class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value=value;
			left=null;
			right=null;
		}
	}
	
	public void printInOrder(Node node) {
		if(node==null)
			return;
		printInOrder(node.left);
		System.out.println(node.value);
		printInOrder(node.right);
	}
	
	public void printPreOrder(Node node) {
		if(node==null)
			return;
		System.out.println(node.value);
		printInOrder(node.left);
		printInOrder(node.right);
	}
	
	public void printPostOrder(Node node) {
		if(node==null)
			return;
		printInOrder(node.left);
		printInOrder(node.right);
		System.out.println(node.value);
	}
	
	public static void main(String arg[]) {
		Tree tree = new Tree();
	
		Node newNode = new Node(1);
		tree.root= newNode;
		
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println("Print in order");
		tree.printInOrder(tree.root);
		System.out.println("Print pre order");
		tree.printPreOrder(tree.root);
		System.out.println("Print post order");
		tree.printPostOrder(tree.root);
		
	}

}
