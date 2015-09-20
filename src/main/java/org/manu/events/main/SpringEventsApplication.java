package org.manu.events.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "org.manu.events")
@SpringBootApplication(scanBasePackages = "org.manu.events")
public class SpringEventsApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringEventsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringEventsApplication.class, args);
    }
}
