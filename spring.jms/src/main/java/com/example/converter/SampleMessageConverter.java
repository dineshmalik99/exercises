package com.example.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class SampleMessageConverter implements MessageConverter{

	@Override
	public Object fromMessage(Message arg0) throws JMSException, MessageConversionException {
		return null;
	}

	@Override
	public Message toMessage(Object arg0, Session arg1) throws JMSException, MessageConversionException {
		return null;
	}

}
