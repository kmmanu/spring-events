package org.manu.events.listener;

import org.manu.events.event.UserGreeted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SynchronousGreetingListener implements ApplicationListener<UserGreeted> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SynchronousGreetingListener.class);

    @Override
    public void onApplicationEvent(UserGreeted event) {
        String greeting = event.getGreetingData().getName();
        greeting += ", I wish you a pleasant day";
        event.getGreetingData().setName(greeting);
        LOGGER.info("Greeted:" + greeting);
    }
}
