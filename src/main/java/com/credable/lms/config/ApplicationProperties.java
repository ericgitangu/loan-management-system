package com.credable.lms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "lms")
public class ApplicationProperties {
    private Cors cors;
    private Soap soap;
    private Scoring scoring;
    private Aws aws;
    private Mqtt mqtt;

    // Getters and setters
    public Cors getCors() { return cors; }
    public void setCors(Cors cors) { this.cors = cors; }
    public Soap getSoap() { return soap; }
    public void setSoap(Soap soap) { this.soap = soap; }
    public Scoring getScoring() { return scoring; }
    public void setScoring(Scoring scoring) { this.scoring = scoring; }
    public Aws getAws() { return aws; }
    public void setAws(Aws aws) { this.aws = aws; }
    public Mqtt getMqtt() { return mqtt; }
    public void setMqtt(Mqtt mqtt) { this.mqtt = mqtt; }

    public static class Cors {
        private String allowedOrigins;
        private String allowedMethods;
        private String allowedHeaders;
        private String exposedHeaders;

        // Getters and setters
        public String getAllowedOrigins() { return allowedOrigins; }
        public void setAllowedOrigins(String allowedOrigins) { this.allowedOrigins = allowedOrigins; }
        public String getAllowedMethods() { return allowedMethods; }
        public void setAllowedMethods(String allowedMethods) { this.allowedMethods = allowedMethods; }
        public String getAllowedHeaders() { return allowedHeaders; }
        public void setAllowedHeaders(String allowedHeaders) { this.allowedHeaders = allowedHeaders; }
        public String getExposedHeaders() { return exposedHeaders; }
        public void setExposedHeaders(String exposedHeaders) { this.exposedHeaders = exposedHeaders; }
    }

    public static class Soap {
        private Kyc kyc;
        private Transaction transaction;

        // Getters and setters
        public Kyc getKyc() { return kyc; }
        public void setKyc(Kyc kyc) { this.kyc = kyc; }
        public Transaction getTransaction() { return transaction; }
        public void setTransaction(Transaction transaction) { this.transaction = transaction; }

        public static class Kyc {
            private String url;
            private String username;
            private String password;

            // Getters and setters
            public String getUrl() { return url; }
            public void setUrl(String url) { this.url = url; }
            public String getUsername() { return username; }
            public void setUsername(String username) { this.username = username; }
            public String getPassword() { return password; }
            public void setPassword(String password) { this.password = password; }
        }

        public static class Transaction {
            private String url;
            private String username;
            private String password;

            // Getters and setters
            public String getUrl() { return url; }
            public void setUrl(String url) { this.url = url; }
            public String getUsername() { return username; }
            public void setUsername(String username) { this.username = username; }
            public String getPassword() { return password; }
            public void setPassword(String password) { this.password = password; }
        }
    }

    public static class Scoring {
        private String baseUrl;
        private Retry retry;

        // Getters and setters
        public String getBaseUrl() { return baseUrl; }
        public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
        public Retry getRetry() { return retry; }
        public void setRetry(Retry retry) { this.retry = retry; }

        public static class Retry {
            private int maxAttempts;
            private long initialDelay;
            private long maxDelay;
            private double multiplier;

            // Getters and setters
            public int getMaxAttempts() { return maxAttempts; }
            public void setMaxAttempts(int maxAttempts) { this.maxAttempts = maxAttempts; }
            public long getInitialDelay() { return initialDelay; }
            public void setInitialDelay(long initialDelay) { this.initialDelay = initialDelay; }
            public long getMaxDelay() { return maxDelay; }
            public void setMaxDelay(long maxDelay) { this.maxDelay = maxDelay; }
            public double getMultiplier() { return multiplier; }
            public void setMultiplier(double multiplier) { this.multiplier = multiplier; }
        }
    }

    public static class Aws {
        private String region;
        private Sqs sqs;
        private Sns sns;
        private Dynamodb dynamodb;

        // Getters and setters
        public String getRegion() { return region; }
        public void setRegion(String region) { this.region = region; }
        public Sqs getSqs() { return sqs; }
        public void setSqs(Sqs sqs) { this.sqs = sqs; }
        public Sns getSns() { return sns; }
        public void setSns(Sns sns) { this.sns = sns; }
        public Dynamodb getDynamodb() { return dynamodb; }
        public void setDynamodb(Dynamodb dynamodb) { this.dynamodb = dynamodb; }

        public static class Sqs {
            private String loanRequestQueue;
            private String scoringRequestQueue;
            private String dlq;

            // Getters and setters
            public String getLoanRequestQueue() { return loanRequestQueue; }
            public void setLoanRequestQueue(String loanRequestQueue) { this.loanRequestQueue = loanRequestQueue; }
            public String getScoringRequestQueue() { return scoringRequestQueue; }
            public void setScoringRequestQueue(String scoringRequestQueue) { this.scoringRequestQueue = scoringRequestQueue; }
            public String getDlq() { return dlq; }
            public void setDlq(String dlq) { this.dlq = dlq; }
        }

        public static class Sns {
            private String loanStatusTopic;

            // Getters and setters
            public String getLoanStatusTopic() { return loanStatusTopic; }
            public void setLoanStatusTopic(String loanStatusTopic) { this.loanStatusTopic = loanStatusTopic; }
        }

        public static class Dynamodb {
            private String endpoint;
            private String tablePrefix;

            // Getters and setters
            public String getEndpoint() { return endpoint; }
            public void setEndpoint(String endpoint) { this.endpoint = endpoint; }
            public String getTablePrefix() { return tablePrefix; }
            public void setTablePrefix(String tablePrefix) { this.tablePrefix = tablePrefix; }
        }
    }

    public static class Mqtt {
        private String brokerUrl;
        private String clientId;
        private String username;
        private String password;
        private String topicPrefix;

        // Getters and setters
        public String getBrokerUrl() { return brokerUrl; }
        public void setBrokerUrl(String brokerUrl) { this.brokerUrl = brokerUrl; }
        public String getClientId() { return clientId; }
        public void setClientId(String clientId) { this.clientId = clientId; }
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getTopicPrefix() { return topicPrefix; }
        public void setTopicPrefix(String topicPrefix) { this.topicPrefix = topicPrefix; }
    }
} 