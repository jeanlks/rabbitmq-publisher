package com.rabbit.publish.rabbitpublisher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitPublisherApplication.class, args);
	}

	@Bean
	public TopicExchange appExchange() {
		return new TopicExchange("test");
	}

	@Bean
	public Queue appQueueGeneric() {
		return new Queue("test");
	}

	@Bean
	public Queue appQueueSpecific() {
		return new Queue("test");
	}

	@Bean
	public Binding declareBindingGeneric() {
		return BindingBuilder.bind(appQueueGeneric()).to(appExchange()).with("test");
	}

	@Bean
	public Binding declareBindingSpecific() {
		return BindingBuilder.bind(appQueueSpecific()).to(appExchange()).with("test");
	}

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
