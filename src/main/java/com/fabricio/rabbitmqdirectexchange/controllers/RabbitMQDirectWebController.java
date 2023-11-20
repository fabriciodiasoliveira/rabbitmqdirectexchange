package com.fabricio.rabbitmqdirectexchange.controllers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class RabbitMQDirectWebController {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping
	public String producer(@RequestBody Dados dados) {

		amqpTemplate.convertAndSend(dados.exchange(), dados.routingKey(), dados.messageData());

		return "Message sent to the RabbitMQ Successfully";
	}

}