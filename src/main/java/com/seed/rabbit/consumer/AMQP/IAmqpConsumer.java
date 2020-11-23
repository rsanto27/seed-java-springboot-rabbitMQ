package com.seed.rabbit.consumer.AMQP;

public interface IAmqpConsumer<T> {

	void consumer(T t);
}
