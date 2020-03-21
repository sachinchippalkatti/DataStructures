package com.sachin.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	static class BstNode{
		public int value;
		public BstNode left;
		public BstNode right;
		
		BstNode(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] arg) {
		BstNode root = null;
		root = insertNode(root, 15);
		root= insertNode(root, 10);
		root= insertNode(root, 20);
		root= insertNode(root, 25);
		root= insertNode(root, 8);
		root= insertNode(root, 12);
		
		System.out.println("search for 8 " + searchNode(root, 8));
		
		System.out.println("Find the Min Value in BST : " + minBstItrarative(root));
		
		System.out.println("Find the Max value in BST : " + maxBstItravative(root));
		
		System.out.println("Find the Min Value in BST : " + minBstRecursive(root));
		
		System.out.println("Find the Max Value in BST : " + maxBstRecrsive(root));
		
		System.out.println("Find the Hight of BST : " + findHightBst(root));
		
		levelOrderTraversal(root);
		
		System.out.println("PerOrder Traversal :");
		perOrderTraversal(root);
		
		System.out.println("InOrder Traversal : ");
		inOrderTraversal(root);
		
		System.out.println("PostOrder Traversal : ");
		postOrderTraversal(root);
		
		System.out.println("Checking the tree is Binary Search tree using range: " + isBST(root));
		
		System.out.println("Checking the tree is Binary Search tree using inorder traversal: " + isBSTInorder(root));
		
		//System.out.println(deleteNode(root,25));
		//System.out.println(deleteNode(root,20));
		System.out.println(deleteNode(root,15));
		
	}

	
	private static BstNode deleteNode(BstNode root, int value) {
		// TODO Auto-generated method stub
		if(root == null) return root;
		if(value < root.value) root.left = deleteNode(root.left, value);
		else if(value > root.value) root.right = deleteNode(root.right, value);
		else {
			if(root.left == null && root.right == null) {
				System.out.println("Dleted case 1: " + root.value);
				root=null;
				return root;
			}
			else if(root.left == null) {
				System.out.println("Dleted case 2: " + root.value);
				root = root.right;
				return root;
			}
			else if(root.right == null) {
				System.out.println("Dleted case 3: " + root.value);
				root= root.left;
				return root;
			}
			else {
				BstNode temp= findMin(root);
				root.value= temp.value;
				System.out.println("Dleted case 4: " + root.value);
				root.right = deleteNode(root.right, temp.value);	
			}
				
		}
		return root;
	}


	private static BstNode findMin(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null) return root;
		while(root.left != null)
			root = root.left;
		
		return root;
	}


	private static boolean isBSTInorder(BstNode root) {
		// TODO Auto-generated method stub
		BstNode prev = null;
		if(root != null) {
		if(!isBSTInorder(root.left)) {
			return false;
		}
		
		if(prev != null && root.value <= prev.value)
			return false;

		prev = root;
		return isBSTInorder(root.right);
		}
		return true;
	}
		


	private static boolean isBST(BstNode root) {
		// TODO Auto-generated method stub
		return checkingBST(root,-1000,1000);
	}


	private static boolean checkingBST(BstNode root, int min, int max) {
		// TODO Auto-generated method stub
		if(root== null) return true;
		
		if(root.value < max && root.value > min && checkingBST(root.left, min , root.value) && checkingBST(root.right, root.value, max))
			return true;
		else
			return false;
	}


	private static void postOrderTraversal(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.value);
	}


	private static void inOrderTraversal(BstNode root) {
		// TODO Auto-generated method stub
		if(root== null) return;
		inOrderTraversal(root.left);
		System.out.println(root.value);
		inOrderTraversal(root.right);
	}


	private static void perOrderTraversal(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		System.out.println(root.value);
		perOrderTraversal(root.left);
		perOrderTraversal(root.right);
	}


	private static void levelOrderTraversal(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null) return;
		Queue<BstNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BstNode current = queue.peek();
			if(current.left != null) queue.add(current.left);
			if(current.right != null) queue.add(current.right);
			System.out.println(queue.poll().value);
		}
	}


	private static int findHightBst(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null) return -1;
		int leftHight = findHightBst(root.left);
		int rightHight = findHightBst(root.right);
		
		return Math.max(leftHight, rightHight) + 1;
	}


	private static int maxBstRecrsive(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null) return -1;
		if(root.right == null) return root.value;
		return maxBstRecrsive(root.right);
	}


	private static int minBstRecursive(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null) return -1;
		if(root.left == null) return root.value;	
		return minBstRecursive(root.left);
	}


	private static int maxBstItravative(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null) return -1;
		while(root.right != null)
			root = root.right;
		
		return root.value;
	}


	private static int minBstItrarative(BstNode root) {
		// TODO Auto-generated method stub
		if(root == null)return -1;
		while(root.left != null)
			root= root.left;
			
		return root.value;		
	}


	private static Boolean searchNode(BstNode root, int data) {
		// TODO Auto-generated method stub
		if(root == null) return false;
		else if(root.value == data) return true;
		else if(data<=root.value)return searchNode(root.left, data);
		else return searchNode(root.right, data);
	}

	private static BstNode insertNode(BstNode root, int value) {
		// TODO Auto-generated method stub
		if(root == null) {
			BstNode newNode = new BstNode(value);
			return newNode;
		}
		if(value <= root.value) {
			root.left=insertNode(root.left,value);
		}else {
			root.right = insertNode(root.right, value);
		}
		return root;
	}

}
