package com.github.adetiamarhadi.kafkaspringbootexample;

import com.github.adetiamarhadi.kafkaspringbootexample.dto.Greeting;
import com.github.adetiamarhadi.kafkaspringbootexample.services.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableKafka
public class KafkaSpringbootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringbootExampleApplication.class, args);
	}

	@Autowired
	MessageProducerService messageProducerService;

	@PostConstruct
	public void run() {
		this.messageProducerService.sendMessage(Greeting.builder().message("hi").name("adet").build());
		this.messageProducerService.sendMessageWithCallback(Greeting.builder().message("selamat pagi").name("kamu").build());
	}

}
