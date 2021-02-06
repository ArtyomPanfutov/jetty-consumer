package devart.dummyjettyconsumer.config;

import org.eclipse.jetty.client.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.JettyClientHttpConnector;
import org.springframework.http.client.reactive.JettyResourceFactory;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Bean
    public JettyResourceFactory resourceFactory() {
        return new JettyResourceFactory();
    }

    @Bean
    public WebClient webClient() {
        ClientHttpConnector connector =
                new JettyClientHttpConnector(resourceFactory(), (consumer) -> new HttpClient());

        return WebClient.builder().clientConnector(connector).build();
    }}
