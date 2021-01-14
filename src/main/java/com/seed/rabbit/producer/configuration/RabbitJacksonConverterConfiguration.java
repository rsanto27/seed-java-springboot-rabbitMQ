package com.seed.rabbit.producer.configuration;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class RabbitJacksonConverterConfiguration {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Bean
	public SimpleRabbitListenerContainerFactory simpleRabbitListener() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(jacksonConverter());
		return factory;
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rt = new RabbitTemplate(connectionFactory);
		rt.setMessageConverter(jacksonConverter());
		return rt;
	}

	Jackson2JsonMessageConverter jacksonConverter() {
		// The mapper is a builder pattern
		final ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().modules(new JavaTimeModule())
				.dateFormat(new StdDateFormat()).build();
		
		return new Jackson2JsonMessageConverter(mapper);
	}
}
