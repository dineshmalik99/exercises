package com.example.demo;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSReceiver {
	public static void main(String[] args) throws JMSException, InterruptedException {
		Connection con = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
		con.start();
		Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("SAPIENT.Q");
		MessageConsumer consumer = session.createConsumer(queue);
		TextMessage msg = (TextMessage) consumer.receive();
		System.out.println("message Recieved: "+msg.getText());
		Thread.sleep(4000);
		String confirmation = "AB-1234";
		System.out.println("Trade confirmation "+confirmation);
		
		TextMessage msgS = session.createTextMessage(confirmation);
		msgS.setJMSCorrelationID(msg.getJMSMessageID());
//		msgS.setJMSCorrelationID("1234456");
		MessageProducer prod = session.createProducer((Queue)msg.getJMSReplyTo());
		prod.send(msgS);
		con.close();
		
	}
}
