package br.com.mq;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SenderMessageMq  {

	private final RabbitTemplate rabbitTemplate;
	private final Recever listener;

	private SenderMessageMq(Recever listener, RabbitTemplate rabbitTemplate) {
		this.listener = listener;
		this.rabbitTemplate = rabbitTemplate;
	}

	public void send(String msg) throws Exception {
		rabbitTemplate.convertAndSend(ConfigApplicationMq.topicExchangeName, ConfigApplicationMq.routingkey, msg);
		listener.getLatch().await(10000, TimeUnit.MILLISECONDS);
	}


}
