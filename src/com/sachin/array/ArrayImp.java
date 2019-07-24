package com.sachin.array;

import java.util.Scanner;

public class ArrayImp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
		int a[] = new int[1];
		int b[] = {1,2,3,4,5};
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the int value in to array");
		for(int i=0;i<a.length;i++) {
			a[i]=keyboard.nextInt();
		}
		
		System.out.println("Array containt:");
		for(int j=0; j<a.length;j++) {	
			System.out.println(a[j]);
		}
		
		//Array of object
		Student studentList[];
		
		System.out.println("Enter the number os student");
		int studentCount = keyboard.nextInt();
		studentList = new Student[studentCount];
		
		
		for(int i=0; i<studentCount; i++) {
			Student s = new Student();
			System.out.println("Enter student details name and age");
			s.name = keyboard.next();
			s.age = keyboard.nextInt();
			studentList[i]=s;
		}
		
		for(Student s : studentList) {
			System.out.println("Student Details:");
			System.out.println(s.name + "    " + s.age);
		}
	}

}
