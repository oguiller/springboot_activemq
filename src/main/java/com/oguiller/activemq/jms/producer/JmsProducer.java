package com.oguiller.activemq.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.oguiller.activemq.model.Customer;

@Component
public class JmsProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${oguiller.activemq.queue}")
	String queue;
	
	public void send(Customer customer){
		jmsTemplate.convertAndSend(queue, customer);
	}
}