package com.sachin.collection;

import java.util.Hashtable;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<Integer, String> ht = new Hashtable<>();
		ht.put(1, "sachin");
		//ht.put(2, null); error
		ht.put(2, "chippalkatti");
		ht.put(2, "anish");
		//ht.put(null, "sachin"); error
		
		ht.entrySet().stream().forEach(System.out::println);
	}

}
