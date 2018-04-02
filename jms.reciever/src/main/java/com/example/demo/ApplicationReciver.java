package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.subscriber.JMSSubscriber;

@SpringBootApplication
public class ApplicationReciver{
	public static void main(String[] args) {
		new Thread(){
			public void run() {
				new JMSSubscriber();
			}

		}.start();
	}
}