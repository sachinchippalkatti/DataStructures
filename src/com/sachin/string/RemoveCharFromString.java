package com.sachin.string;

public class RemoveCharFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String displayed_name="ACSD1/c1/c2/sd2";
		
		displayed_name=displayed_name.replaceAll("([a-z,A-Z])", "");
		System.out.println(displayed_name);
	}

}
