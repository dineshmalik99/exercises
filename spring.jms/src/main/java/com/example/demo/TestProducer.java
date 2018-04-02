package com.example.demo;

import java.text.DecimalFormat;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TestProducer {
	
	public static void main(String[] args) throws JMSException {
		Connection con = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection(); 
		con.start();
		Session session = con.createSession(false,Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("SAPIENT.T");
		MessageProducer producer = session.createProducer(topic);
		
		DecimalFormat df = new DecimalFormat("##.00");
		String price = df.format(95.0+Math.random());
		TextMessage msg = session.createTextMessage("JMSTEST "+price);
		producer.send(msg);
		System.out.println("mesg sent for price "+price);
		con.close();
		
	}

}
