package com.seed.rabbit.producer.AMQP;

public interface IAmqpProducer<T> {
	void producer(T t);
}
