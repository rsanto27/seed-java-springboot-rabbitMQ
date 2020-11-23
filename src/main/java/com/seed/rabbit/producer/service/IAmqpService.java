package com.seed.rabbit.producer.service;

import com.seed.rabbit.DTO.Message;

public interface IAmqpService {
	void sendToConsumer(Message m);
}
