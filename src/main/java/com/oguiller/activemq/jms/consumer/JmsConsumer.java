package com.oguiller.activemq.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.oguiller.activemq.model.Customer;
import com.oguiller.activemq.model.MessageStorage;

@Component
public class JmsConsumer {
	@Autowired
	private MessageStorage customerStorage;
	
	@JmsListener(destination = "${oguiller.activemq.queue}", containerFactory="jsaFactory")
	public void receive(Customer customer){
		System.out.println("Recieved Message: " + customer);
		customerStorage.add(customer);
	}
}