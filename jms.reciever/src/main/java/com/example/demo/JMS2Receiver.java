package com.example.demo;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;

import com.sun.messaging.ConnectionFactory;

public class JMS2Receiver {
	public static void main(String[] args) throws JMSException, InterruptedException {
		ConnectionFactory cf = new ConnectionFactory();
		JMSContext context = cf.createContext();
		Queue queue = context.createQueue("SAPIENTREQ_Q");
		Message msg = context.createConsumer(queue).receive();
		String payload = msg.getBody(String.class);
		System.out.println("Message is : "+payload);
		Thread.sleep(4000);
		String confirmation ="";
		System.out.println("sending confirmation"+confirmation);
	}
}
