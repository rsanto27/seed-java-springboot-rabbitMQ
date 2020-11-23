package com.seed.rabbit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.seed.rabbit.DTO.Message;
import com.seed.rabbit.producer.service.IAmqpService;

@RestController
public class AmqpApi {
	
	@Autowired
	private IAmqpService service;
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PostMapping(value = "/send")
	public void sendToConsumer(@RequestBody Message m) {
		service.sendToConsumer(m);
	}
}
