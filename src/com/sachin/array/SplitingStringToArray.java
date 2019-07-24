package com.sachin.array;

/**
 * @author sc849m
 *
 */
public class SplitingStringToArray {

	public static void main(String arg[]) {
		System.out.println("Welcome to spliting the string to char array");
		
		String s = "sachin";
		System.out.println(s);
		String[] splitChar = s.split("");
		for(String s1 : splitChar) {
		System.out.println(s1);
		}
	}
}
