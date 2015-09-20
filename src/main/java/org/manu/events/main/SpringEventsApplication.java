package org.manu.events.main;

import org.manu.events.multicaster.DistributiveEventMulticaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@SpringBootApplication(scanBasePackages = "org.manu.events")
public class SpringEventsApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringEventsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringEventsApplication.class, args);
    }

    private SimpleApplicationEventMulticaster asyncEventMulticaster() {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(new SimpleAsyncTaskExecutor("AsyncEvent"));
        return multicaster;
    }

    private SimpleApplicationEventMulticaster syncEventMulticaster() {
        return new SimpleApplicationEventMulticaster();
    }

    @Bean
    public DistributiveEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster asyncEventMulticaster = asyncEventMulticaster();
        SimpleApplicationEventMulticaster syncEventMulticaster = syncEventMulticaster();
        return new DistributiveEventMulticaster(asyncEventMulticaster, syncEventMulticaster);
    }
}
