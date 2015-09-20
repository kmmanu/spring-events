package org.manu.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEventsApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringEventsApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("Started the application....");
        SpringApplication.run(SpringEventsApplication.class, args);
    }
}
