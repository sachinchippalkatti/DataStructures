package com.sachin.array;

import java.util.Scanner;

public class TwoDimentionArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][] = new int[2][2];
		Scanner keyboard = new Scanner(System.in);
		
		for(int i=0 ; i<2; i++) {
			for(int j=0; j<2; j++) {
				a[i][j]= keyboard.nextInt();
			}
		}
		
		for(int i=0; i<2; i++) {
			for(int j=0;j<2; j++) {
				System.out.print("\t"+ a[i][j]);
			}
			System.out.println();
		}
		System.out.println(TwoDimentionArray.isDiagonalMatrix(a));
	}
	
	static boolean isDiagonalMatrix(int[][] matrix) {
	    for(int i=0;i<matrix.length; i++){
	        for(int j=0 ; j<matrix[i].length;j++){
	            if(i!=j && matrix[i][j] !=0)
	                return false;
	        }
	    }
	    return true;
	}

}
