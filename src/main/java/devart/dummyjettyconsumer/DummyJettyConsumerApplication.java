package devart.dummyjettyconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class DummyJettyConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DummyJettyConsumerApplication.class, args);
	}

}
