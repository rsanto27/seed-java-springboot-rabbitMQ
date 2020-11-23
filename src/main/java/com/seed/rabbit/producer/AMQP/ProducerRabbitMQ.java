package com.seed.rabbit.producer.AMQP;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.seed.rabbit.DTO.Message;

@Component
public class ProducerRabbitMQ implements IAmqpProducer<Message> {
	
	@Autowired
	private RabbitTemplate rT;
	
	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;
	@Value("${spring.rabbitmq.request.exchange.producer}")
	private String exchange;

	@Override
	public void producer(Message t) {
		try {
			rT.convertAndSend(exchange, queue, t);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
		
	}
}
