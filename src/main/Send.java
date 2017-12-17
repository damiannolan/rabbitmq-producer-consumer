package main;

import java.io.IOException;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	private final static String QUEUE_NAME = "TEST";
	
	public static void main(String[] args) throws IOException {
		// Get a connection channel from the factory
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		//String message = "Hello RabbitMQ";
		
		Message message = new Message(0, "Hello RabbitMQ!");
		
		channel.basicPublish("", QUEUE_NAME, null, SerializationUtils.serialize(message));
		System.out.println(" [x] Sent : " + message);
		
		channel.close();
		connection.close();
	}
}
