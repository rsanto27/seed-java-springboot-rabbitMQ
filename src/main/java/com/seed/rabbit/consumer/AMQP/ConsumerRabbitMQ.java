package com.seed.rabbit.consumer.AMQP;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.seed.rabbit.DTO.Message;

@Component
public class ConsumerRabbitMQ implements IAmqpConsumer<Message> {

//	@Override
//	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
//	public void consumer(Message t) {
//		System.out.println(t.getText());
//	}
	
	// DeadLetter test
	@Override
	@RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
	public void consumer(Message t) {
		throw new AmqpRejectAndDontRequeueException("Problems when consumer queue, sending to deadLetter. Data: " + t.getText());
	}

}
