package com.sachin.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionSort {

	public static void main(String args[]) {
		List<String> list = Arrays.asList("sachin","anand","bala");
		list.stream().forEach(System.out::println);
		Collections.sort(list);
		list.stream().forEach(System.out::println);
		
		
		System.out.println("********************* PERSON **********************");
		
		Person p1 = new Person("sachin","chippalkatti");// jvm creates new object and reference is returned
		Person p2 = new Person("sachin","chippalkatti");// jvm create new another object and reference is returned 
		Person p3 = p1;
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p1);
		System.out.println(p2);		
		
		Map<Person,String> per = new HashMap<>();
		per.put(p1, "sachin");
		//per.put(p2, "Value");
		
		System.out.println(per.get(p2)); // it will return null because hashcode is not matching
		//System.out.println(per.get(p2));
		
		if(p1 == p3) { // == operator compare with reference which is different 
			System.out.println("p1 == p3");
		}
		
		if(p1.equals(p2)) {
			System.out.println("p1.equal(p2)");
		}
		
		System.out.println("****************** STRING Initilization *****************");
		
		Map<String,String> str = new HashMap<>();
		String str1 = "sachin";
		String str2 = "sachin";
		str.put(str1, "sachin");
		str.put(str2, "value");
		
		if(str1 == str2) {
			System.out.println("str1 == str2");
		}
		
		if(str1.equals(str1)) {
			System.out.println("str1.equal(str1)");
		}
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str.get("sachin"));
		
		System.out.println("****************** STRING Initilization using New *****************");
		
		Map<String,String> strMap = new HashMap<>();
		String str3 = new String("sachin").intern();
		String str4 = new String("sachin").intern();
		strMap.put(str3, "sachin");
		strMap.put(str4, "value");
		
		if(str3 == str4) {
			System.out.println("str3 == str4");
		}
		
		if(str3.equals(str4)) {
			System.out.println("str3.equal(str4)");
		}
		
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		System.out.println(strMap.get(str3));
		System.out.println(strMap.get(str4));
		
	}
}

class Person{
	private String name;
	private String last;
	
	Person(String name, String last){
		this.name=name;
		this.last=last;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*@Override
	public String toString() {
		return "Person [name=" + name + ", last=" + last + "]";
	}*/
	
}
