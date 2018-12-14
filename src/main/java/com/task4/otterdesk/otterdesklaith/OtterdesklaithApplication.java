package com.task4.otterdesk.otterdesklaith;

import com.task4.otterdesk.otterdesklaith.Service.MessageSender;
import com.task4.otterdesk.otterdesklaith.model.BluePrint;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OtterdesklaithApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OtterdesklaithApplication.class, args);
		OtterdesklaithApplication application=context.getBean(OtterdesklaithApplication.class);
		application.process(application);
	}


	@Autowired
	MessageSender messageSender;

	public void process(OtterdesklaithApplication application) {

		MessageSender sender = application.messageSender;
		sender.send();
	}


	@Bean
	public  BluePrint getBluePrint(){

		return new BluePrint();
	}


	@Bean
	public Queue getQueue(){
		return new Queue("BluePrints") ;

	}

	@Bean
	public MessageConverter jsonMessageConverter(){
		return new Jackson2JsonMessageConverter();
	}

	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}

}

