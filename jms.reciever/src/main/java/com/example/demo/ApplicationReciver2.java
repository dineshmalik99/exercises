package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.subscriber.JMSDurableSubscriber;

@SpringBootApplication
public class ApplicationReciver2{
	public static void main(String[] args) {
		new Thread(){
			public void run() {
				new JMSDurableSubscriber();
			}

		}.start();
	}
}