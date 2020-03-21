package com.sachin.linkedlist;

//Java program to create a new linked list 
//from two given linked list 
//of the same size with 
//the greater element among the two at each node 
import java.util.*; 

class GFG 
{ 

//Representation of node 
static class Node 
{ 
	int data; 
	Node next; 
}

//Function to insert node in a linked list 
static Node insert(Node root, int item) 
{ 
	Node ptr, temp; 
	temp = new Node(); 
	temp.data = item; 
	temp.next = null; 

	if (root == null) 
		root = temp; 
	else { 
		ptr = root; 
		while (ptr.next != null) 
			ptr = ptr.next; 

		ptr.next = temp; 
	} 
	return root; 
} 

//Function which returns new linked list 
static Node newList(Node root1, Node root2) 
{ 
	Node ptr1 = root1, ptr2 = root2, ptr; 
	Node root = null, temp; 

	while (ptr1 != null) { 
		temp = new Node(); 
		temp.next = null; 

		// Compare for greater node 
		if (ptr1.data < ptr2.data) 
			temp.data = ptr2.data; 
		else
			temp.data = ptr1.data; 

		if (root == null) 
			root = temp; 
		else { 
			ptr = root; 
			while (ptr.next != null) 
				ptr = ptr.next; 

			ptr.next = temp; 
		} 
		ptr1 = ptr1.next; 
		ptr2 = ptr2.next; 
	} 
	return root; 
} 

static Node newListadding(Node root1, Node root2,int k) {
	Node root=null,ptr1,nextptr, last2;
	root = root1;
	ptr1=root1;
	nextptr = null;
	while(ptr1.next != null && ptr1.data != k)
		ptr1=ptr1.next;

	nextptr = ptr1.next;
	
	last2=root2;
	while(last2.next !=null)
		last2=last2.next;
	
	ptr1.next = root2;
	last2.next = nextptr;
	return root;
}

static Node deleteEveryKNode(Node root, int k) {
	if(root == null) {
		System.out.println("List is empty");
		return null;
	}
	
	Node curr, prev;
	prev = null;
	curr= root;
	int count=1;
	
	while(curr != null) {
		
		if(count == k) {
			prev.next=curr.next;
			count=0;
		}
		count++;
		prev=curr;
		curr= curr.next;
	}
	return root;
}

static Node deletingAlternativeNode(Node head) {
	Node curr= head;
	if(curr== null)
		return null;
	if(curr.next == null)
		return head;
	while(curr != null && curr.next!=null){
		curr.next=curr.next.next;
		curr=curr.next;
	}
	
	return head;
}
static Node reverseLinkedList(Node head) {
	Node curr,next1,prev;
	
	curr=head;
	next1= null;
	prev=null;
	
	while(curr != null) {
		next1=curr.next;
		curr.next = prev;
		prev =curr;
		curr=next1;
	}
	head=prev;
	return head;
}

static Node reverseUntil(Node curr, Node prev) {
	Node head = null ;
	if(curr.next == null) {
		head=curr;
		curr.next=prev;
		return head;
	}
	
	Node next1 = curr.next;
	curr.next= prev;
	head =reverseUntil(next1,curr);
	head = prev;
	return head;
}


static Node reverseEveryKthElement(Node root, int k) {
	Node curr,prev,next1;
	
	curr=root;
	prev= null;
	next1=null;
	int count =0;
	while(curr != null && count <k) {
		next1= curr.next;
		curr.next = prev;
		prev=curr;
		curr= next1;
		count++;
	}
	
	if(next1 != null)
		root.next=reverseEveryKthElement(next1,k);
	
	root = prev;
	return root;
	
}

//Recursive function to reverse the consecutive 
//even nodes of the linked list 
static Node reverseEvenElement(Node head, Node prev) 
{ 

 // Base case 
 if (head == null) 
     return null; 

 Node temp; 
 Node curr; 
 curr = head; 

 // Reversing nodes until curr node's value 
 // turn odd or Linked list is fully traversed 
 while (curr != null && curr.data % 2 == 0)  
 { 
     temp = curr.next; 
     curr.next = prev; 
     prev = curr; 
     curr = temp; 
 } 

 // If elements were reversed then head 
 // pointer needs to be changed 
 if (curr != head)  
 { 
     head.next = curr; 

     // Recur for the remaining linked list 
     curr = reverseEvenElement(curr, null); 
     return prev; 
 } 

 // Simply iterate over the odd value nodes 
 else
 { 
     head.next = reverseEvenElement(head.next, head); 
     return head; 
 } 
} 



Node reverse(Node head, int k) 
{ 
   Node current = head; 
   Node next = null; 
   Node prev = null; 
     
   int count = 0; 

   /* Reverse first k nodes of linked list */
   while (count < k && current != null)  
   { 
       next = current.next; 
       current.next = prev; 
       prev = current; 
       current = next; 
       count++; 
   } 

   /* next is now a pointer to (k+1)th node  
      Recursively call for the list starting from current. 
      And make rest of the list as next of first node */
   if (next != null)  
      head.next = reverse(next, k); 

   // prev is now head of input list 
   return prev; 
}


//Function to reverse the circular linked list  
static Node reverse(Node head_ref)  
{  
 // if list is empty  
 if (head_ref == null)  
     return null;  

 // reverse procedure same as reversing a  
 // singly linked list  
 Node prev = null;  
 Node current = head_ref;  
 Node next;  
 do 
 {  
     next = current.next;  
     current.next = prev;  
     prev = current;  
     current = next;  
 } while (current != (head_ref));  

 // adjutsing the links so as to make the  
 // last node point to the first node  
 (head_ref).next = prev;  
 head_ref = prev;  
 return head_ref; 
}  

//Function to reverse the linked  
//list according to its size  
static Node reverseSizeBy2Util(Node head, int k,  
                         boolean skipMiddle)  
{  
 if (head == null)  
     return null;  

 int count = 0;  
 Node curr = head;  
 Node prev = null;  
 Node next=null;  

 // Reverse current block of list.  
 while (curr!=null && count < k) 
 {  
     next = curr.next;  
     curr.next = prev;  
     prev = curr;  
     curr = next;  
     count++;  
 }  

 // If size is even, reverse next block too.  
 if (!skipMiddle)  
     head.next = reverseSizeBy2Util(next, k, false);  

 else 
 {  

     // if size is odd, skip next element  
     // and reverse the block after that.  
     head.next = next;  
     if (next != null)  
         next.next = reverseSizeBy2Util(next.next,  
                                         k, true);  
 }  
 return prev;  
}  

static void display(Node root) 
{ 
	while (root != null) 
	{ 
		System.out.print( root.data + "->"); 
		root = root.next; 
	} 
	System.out.println(); 
} 

//Driver code 
public static void main(String args[]) 
{ 
	Node root1 = null, root2 = null, root = null; 

	// First linked list 
	root1=insert(root1, 5); 
	root1=insert(root1, 2); 
	root1=insert(root1, 3); 
	root1=insert(root1, 8); 

	System.out.print("First List: "); 
	display(root1); 

	// Second linked list 
	root2=insert(root2, 1); 
	root2=insert(root2, 7); 
	root2=insert(root2, 4); 
	root2=insert(root2, 5); 

	System.out.print( "Second List: "); 
	display(root2); 

	root = newList(root1, root2); 
	System.out.print("New List: "); 
	display(root); 
	
	
	System.out.println("Adding two list");
	Node root3 = newListadding(root1,root2,2);
	display(root3);
	
	System.out.println("Deleting every kth element");
	Node root4 = deleteEveryKNode(root1,3);
	display(root4);
	
	System.out.println("Reverse the linkedlist");
	Node root5 = reverseLinkedList(root1);
	display(root5);
	
	System.out.println("Reverse the linkedlist");
	Node root6 = reverseUntil(root1, null);;
	display(root6);
	
	display(root5);
	
	System.out.println("Reverse the linkedlist every K th element");
	Node root7 = reverseEveryKthElement(root5, 2);
	display(root7);
	
	System.out.println("Deleting every alternative node");
	display(root5);
	Node root8 = deletingAlternativeNode(root5);	
	display(root8);
	display(root7);
	root8 = deletingAlternativeNode(root7);
	display(root8);
} 
} 

