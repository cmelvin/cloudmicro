package genericpubservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(MessageChannel.class)
@EnableRabbit
public class GenericSubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericSubServiceApplication.class, args);
	}

}
