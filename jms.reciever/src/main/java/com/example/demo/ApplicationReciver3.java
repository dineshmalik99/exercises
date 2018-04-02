package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.subscriber.JMSDurableSubscriber2;

@SpringBootApplication
public class ApplicationReciver3{
	public static void main(String[] args) {
		new Thread(){
			public void run() {
				new JMSDurableSubscriber2();
			}

		}.start();
	}
}