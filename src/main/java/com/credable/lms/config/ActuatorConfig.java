package com.credable.lms.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ActuatorConfig {

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Bean
    public InfoContributor applicationInfoContributor() {
        return builder -> {
            Map<String, Object> details = new HashMap<>();
            details.put("name", "Loan Management System");
            details.put("version", "1.0.0");
            details.put("description", "A system for managing loan applications and processing");
            
            Map<String, String> contact = new HashMap<>();
            contact.put("developer", "Credable Development Team");
            contact.put("email", "tech.hiring@credable.io");
            details.put("contact", contact);
            
            builder.withDetail("application", details);
        };
    }
}