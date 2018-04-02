package com.example.subscriber;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSSubscriber implements MessageListener {
	
	public JMSSubscriber() {
		try {
			TopicConnection con = new ActiveMQConnectionFactory("tcp://localhost:61616").createTopicConnection();
			con.start();
			TopicSession session = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic("SAPIENT.T");
			TopicSubscriber tSub = session.createSubscriber(topic);
			tSub.setMessageListener(this);
			System.out.println("Waiting for messages");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(Message arg) {
		TextMessage message = (TextMessage) arg;
		try {
			System.out.println(message.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
