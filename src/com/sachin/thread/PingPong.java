package com.sachin.thread;

class PingPongThread  implements Runnable{
	
	public static String value = "PING";
	public static Object obj = new Object();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0 ; i<10;i++) {
			synchronized (obj) {
				if("PONG".equals(value)) {
					System.out.println(value + " : " +Thread.currentThread().getName());
					value="PING";
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(value + " : " +Thread.currentThread().getName());
				value ="PONG";
				obj.notifyAll();			
			}
		}
		
	}
}

public class PingPong{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PingPongThread ping = new PingPongThread();
		PingPongThread pong = new PingPongThread();
		
		Thread t1 = new Thread(ping,"PING");
		Thread t2 = new Thread(pong,"PONG");
		t1.start();
		t2.start();
	}
}
