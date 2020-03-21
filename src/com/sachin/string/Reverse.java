package com.sachin.string;

import java.util.Stack;

public class Reverse {
	 
	public static void main(String[] args) {
 
 
		String myStr = "Guru99";
		
		//reverse using charAt function
		String result = "";
		for(int i=myStr.length()-1; i>=0;i--) {
			result = result + myStr.charAt(i);
		}
		System.out.println(" String reverse :" +result + Reverse.reverseString(result));
		
		//reverse using Stack
		result="";
		Stack<Character> stackStr = new Stack<Character>();
		for(int i=0 ; i<myStr.length(); i++) {
			stackStr.push(myStr.charAt(i));
		}
		for(int j=0; j<myStr.length(); j++) {
			result = result + stackStr.pop();
		}
		System.out.println(" String reverse stack :" + result);
		
		//Using StringBuilder
		String input = "Hello welcome";		  
        StringBuilder input1 = new StringBuilder(); 
  
        // append a string into StringBuilder input1 
        input1.append(input); 
  
        // reverse StringBuilder input1 
        input1 = input1.reverse(); 
  
        // print reversed String 
        System.out.println(input1); 
        
        
        
        
        // convert String to character array 
        // by using toCharArray 
        char[] try1 = input.toCharArray(); 
  
        for (int i = try1.length-1; i>=0; i--) 
            System.out.print(try1[i]); 
        
        
        
        
        
		
		//create Method and pass and input parameter string 
		String reversed = reverseString(myStr);
		System.out.println("The reversed string is: " + reversed);
		
	}
 
 
	//Method take string parameter and check string is empty or not
	public static String reverseString(String myStr)
	{
		if (myStr.isEmpty()){
		 System.out.println("String in now Empty");	
		 return myStr;
		}
		//Calling Function Recursively
		System.out.println("String to be passed in Recursive Function: "+myStr.substring(1));
		return reverseString(myStr.substring(1)) + myStr.charAt(0);
	}
 
}