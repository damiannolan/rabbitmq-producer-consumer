package main;

import java.io.IOException;

import com.rabbitmq.client.*;

public class Recieve {
	private final static String QUEUE_NAME = "TEST";
	
	public static void main(String[] args) throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL + C");
		
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope env, AMQP.BasicProperties props, byte[] body)
				throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Recieved: " + message);
			}
		};
		
		channel.basicConsume(QUEUE_NAME, true, consumer);
		
	}
}
