package com.sachin.string;

import java.util.regex.Pattern;

public class StringReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "Hello sachin chippalkatti";
		String result = "";
		
		//Pattern pattern = Pattern.compile("\\s");
		String[] temp = input.split(" ");
		
		for(int i=temp.length-1 ; i>=0; i--) {
			result = result + temp[i] + " ";
		}
		System.out.println(result);
		
		for(String s: temp) {
			for(int j=s.length()-1 ; j>=0;j--) {
				System.out.print(s.charAt(j));
			}
			System.out.print(" ");
		}
	}

}
