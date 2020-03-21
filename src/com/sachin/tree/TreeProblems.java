package com.sachin.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeProblems {
	
	static class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			super();
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(25);
		root.left.right = new Node(8);
		root.right.left = new Node(12);
		root.right.right = new Node(1);
				
		TreeProblems t = new TreeProblems();
		System.out.println("\n PreOrder Traversal");
		t.preOrder(root);
		System.out.println("\n InOrder Traversal");
		t.inOrder(root);
		System.out.println("\n Post Order Traversal");
		t.postOrder(root);
		System.out.println("\n Level Order Traversal");
		t.levelOrder(root);
		System.out.println("\n Zig Zig Traversal");
		t.zigzig(root);
	}

	private void zigzig(Node root) {
		// TODO Auto-generated method stub
		Stack<Node> cl = new Stack<>();
		Stack<Node> nl = new Stack<>();
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		cl.add(root);
		boolean flag = true;
		while(!cl.isEmpty()) {
			Node node = cl.pop();
			System.out.print(node.value + "->");
			if(flag) {
				if(node.left != null)
					nl.add(node.left);
				if(node.right != null)
					nl.add(node.right);
			}else {
				if(node.right != null)
					nl.add(node.right);
				if(node.left != null)
					nl.add(node.left);
			}
			
			if(cl.isEmpty()) {
				Stack<Node> temp = nl;
				nl=cl;
				cl=temp;
				flag =!flag;
			}
		}
	}

	private void levelOrder(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> q = new LinkedList<>();
		if(root == null) {
			System.out.println("tree is empty");
			return;
		}
		q.add(root);
		System.out.println("");
		while(!q.isEmpty()) {
			Node node = q.poll();
			System.out.print(node.value + "->");
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
		
	}

	private void postOrder(Node root) {
		// TODO Auto-generated method stub
		if(root == null)return;
		if(root.left == null && root.right == null)return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.value + "->");
	}

	private void inOrder(Node root) {
		// TODO Auto-generated method stub
		if(root == null)return;
		if(root.left == null && root.right == null)return;
		inOrder(root.left);
		System.out.print(root.value + "->");
		inOrder(root.right);
	}

	private void preOrder(Node root) {
		// TODO Auto-generated method stub
		if(root == null)return;
		if(root.left == null && root.right == null) return;
		System.out.print(root.value + "->");
		preOrder(root.left);
		preOrder(root.right);
	}

}
