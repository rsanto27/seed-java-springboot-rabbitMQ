package com.seed.rabbit.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seed.rabbit.DTO.Message;
import com.seed.rabbit.producer.AMQP.IAmqpProducer;

@Service
public class RabbitMQService implements IAmqpService {

	@Autowired
	private IAmqpProducer<Message> amqp;
	
	@Override
	public void sendToConsumer(Message m) {
		amqp.producer(m);
	}
}
