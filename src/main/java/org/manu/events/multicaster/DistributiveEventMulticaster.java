package org.manu.events.multicaster;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.ResolvableType;

public class DistributiveEventMulticaster implements ApplicationEventMulticaster {

    private final ApplicationEventMulticaster asyncEventMulticaster;
    private final ApplicationEventMulticaster syncEventMulticaster;

    public DistributiveEventMulticaster(ApplicationEventMulticaster asyncEventMulticaster,
                                        ApplicationEventMulticaster syncEventMulticaster) {
        this.asyncEventMulticaster = asyncEventMulticaster;
        this.syncEventMulticaster = syncEventMulticaster;
    }

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        // choose multicaster by annotation
        if (listener.getClass().isAnnotationPresent(AsyncListener.class)) {
            asyncEventMulticaster.addApplicationListener(listener);
        } else {
            syncEventMulticaster.addApplicationListener(listener);
        }
    }

    @Override
    public void addApplicationListenerBean(String listenerBeanName) {
        // do nothing
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        asyncEventMulticaster.removeApplicationListener(listener);
        syncEventMulticaster.removeApplicationListener(listener);
    }

    @Override
    public void removeApplicationListenerBean(String listenerBeanName) {
        // do nothing
    }

    @Override
    public void removeAllListeners() {
        syncEventMulticaster.removeAllListeners();
        asyncEventMulticaster.removeAllListeners();
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        syncEventMulticaster.multicastEvent(event);
        asyncEventMulticaster.multicastEvent(event);
    }

    @Override
    public void multicastEvent(ApplicationEvent event, ResolvableType resolvableType) {
        syncEventMulticaster.multicastEvent(event);
        asyncEventMulticaster.multicastEvent(event);
    }
}
