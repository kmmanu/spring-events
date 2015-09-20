package org.manu.events.listener;

import org.manu.events.event.UserGreeted;
import org.manu.events.multicaster.AsyncListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@AsyncListener
@Component
public class GreetingListener implements ApplicationListener<UserGreeted> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingListener.class);

    @Override
    public void onApplicationEvent(UserGreeted event) {
        String name = event.getGreetingData().getName();
        name += " (sorry, but " + name + " sounds really stupid...)";
        event.getGreetingData().setName(name);
        LOGGER.info("Greeted:" + name);
    }
}
