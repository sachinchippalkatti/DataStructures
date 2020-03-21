package com.sachin.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementAndDecrement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Count count = new Count();
		for(int i =0 ; i<100;i++) {
			new Thread(new Runnable() {
				public void run() {
					count.increment();
				}
			}).start();
			Thread.sleep(10);
		}
		
		System.out.println("Incerment :: " + count.getvalue());
		for(int i =0 ; i<50;i++) {
			new Thread(new Runnable() {
				public void run() {
					count.decrement();
				}
			}).start();
		}
		
		Thread.sleep(6000);
		System.out.println("Decrement :: " + count.getvalue());
	}

}

class Count{
	private AtomicInteger c= new AtomicInteger();
	
	public void increment() {
		c.getAndIncrement();
	}
	
	public int getvalue() {
		return c.get();
	}
	
	public void decrement() {
		c.getAndDecrement();
	}
}
