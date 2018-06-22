package com.example.demo;

import javax.jms.JMSContext;
import javax.jms.Queue;

import com.sun.messaging.ConnectionFactory;

public class JMS2ContextSender {
	
	public static void main(String[] args) {
		ConnectionFactory cf = new ConnectionFactory();
		JMSContext context = cf.createContext();
		Queue queue = context.createQueue("SAPIENTREQ_Q");
		context.createProducer().send(queue, "Sample JMSContext message");
		System.out.println("Message sent");
	}

}
