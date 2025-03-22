package com.credable.lms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.retry.backoff.UniformRandomBackOffPolicy;

import java.util.Collections;

@Configuration
public class RetryConfig {

    @Value("${lms.scoring.retry.max-attempts}")
    private int maxAttempts;

    @Value("${lms.scoring.retry.initial-delay}")
    private long initialDelay;

    @Value("${lms.scoring.retry.max-delay}")
    private long maxDelay;

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        
        // Configure backoff policy with jitter
        UniformRandomBackOffPolicy backOffPolicy = new UniformRandomBackOffPolicy();
        backOffPolicy.setMinBackOffPeriod(initialDelay);
        backOffPolicy.setMaxBackOffPeriod(maxDelay);
        
        // Configure retry policy
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(
                maxAttempts,
                Collections.singletonMap(Exception.class, true)
        );
        
        retryTemplate.setBackOffPolicy(backOffPolicy);
        retryTemplate.setRetryPolicy(retryPolicy);
        
        return retryTemplate;
    }
}