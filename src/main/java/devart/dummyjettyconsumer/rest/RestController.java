package devart.dummyjettyconsumer.rest;

import com.google.common.base.Stopwatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.TimeUnit;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final WebClient webClient;

    @Autowired
    public RestController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/call")
    public void call() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        webClient.get()
                .uri("http://localhost:8084/get")
                .retrieve()
                .bodyToMono(DummyDto[].class)
                .block();
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
