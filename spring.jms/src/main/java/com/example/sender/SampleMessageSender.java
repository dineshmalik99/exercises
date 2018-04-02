package com.example.sender;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Queue;

import org.springframework.jms.core.JmsTemplate;

import com.example.pojo.Employee;

public class SampleMessageSender {
	
	private JmsTemplate jmsTemplate;
	private Queue queue;
	
	public void simpleSend() {
        jmsTemplate.send(queue, s -> s.createTextMessage("hello queue world"));
    }
	
	public void sendMessage(Employee employee) { 
        System.out.println("Jms Message Sender : " + employee); 
        Map<String, Object> map = new HashMap<>(); 
        map.put("name", employee.getName()); map.put("age", employee.getAge()); 
        jmsTemplate.convertAndSend(map); 
    } 

}
