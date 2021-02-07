package devart.dummyjettyconsumer;


import devart.dummyjettyconsumer.service.DummyConsumerService;
import devart.dummyjettyconsumer.service.DummyDto;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = {devart.dummyjettyconsumer.service.DummyConsumerService.class, devart.dummyjettyconsumer.config.WebClientConfiguration.class})
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class JettyBenchmark extends AbstractBenchmark {
    private static DummyConsumerService service;

    @Autowired
    void setDummyConsumerService(DummyConsumerService dummyConsumerService) {
        JettyBenchmark.service = dummyConsumerService;
    }

    /*
     * There is no @Test annotated method within here, because the AbstractBenchmark
     * defines one, which spawns the JMH runner. This class only contains JMH/Benchmark
     * related code.
     */
    @Setup(Level.Trial)
    public void setupBenchmark() {

    }

    @Benchmark
    public void getDummyDto() {
        DummyDto[] dummyDtos = service.get();
        System.out.println(dummyDtos.length);
    }
}
