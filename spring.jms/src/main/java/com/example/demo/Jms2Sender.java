package com.example.demo;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Jms2Sender {
	public static void main(String[] args) throws JMSException {
		Connection con = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
		con.start();
		Session session = con.createSession(false,Session.AUTO_ACKNOWLEDGE);
		Queue queueReq = session.createQueue("SAPIENT.Q");
		Queue queueResp = session.createQueue("SAPIENTRESP.Q");
		TextMessage msg = session.createTextMessage("Test Message queue Send 1000");
		msg.setJMSReplyTo(queueResp);
		MessageProducer prod = session.createProducer(queueReq);
		prod.send(msg);
		System.out.println("Message sent");
		
		String filter = "JMSCorrelationID = '"+msg.getJMSMessageID()+"'";
		MessageConsumer consumer = session.createConsumer(queueResp,filter);
		
		TextMessage msgR = (TextMessage) consumer.receive();
		System.out.println("Msg Recieved"+msgR.getText());
		con.close();
	}

}
