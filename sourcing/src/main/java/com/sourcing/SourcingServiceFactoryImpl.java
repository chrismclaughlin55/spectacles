package com.sourcing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SourcingServiceFactoryImpl implements  SourcingServiceFactory {
    @Autowired
    private List<SourcingService> services;

    @Override
    public SourcingService get(String context) {
        for (SourcingService service : services) {
            if (service.supports(context)) {
                return service;
            }
        }
        throw new IllegalArgumentException("Could not find service with context" + context);
    }
}
