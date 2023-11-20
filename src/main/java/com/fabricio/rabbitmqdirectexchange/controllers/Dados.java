package com.fabricio.rabbitmqdirectexchange.controllers;

public record Dados(String exchange, String routingKey, String messageData) {
}