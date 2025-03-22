package com.credable.lms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
public class SoapConfig {

    @Value("${lms.soap.kyc.username}")
    private String kycUsername;

    @Value("${lms.soap.kyc.password}")
    private String kycPassword;

    @Bean
    public Jaxb2Marshaller kycMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.credable.lms.client.soap.generated");
        return marshaller;
    }

    @Bean
    public Jaxb2Marshaller transactionMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.credable.lms.client.soap.generated");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate kycWebServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(kycMarshaller());
        webServiceTemplate.setUnmarshaller(kycMarshaller());
        webServiceTemplate.setInterceptors(new ClientInterceptor[]{securityInterceptor()});
        return webServiceTemplate;
    }

    @Bean
    public WebServiceTemplate transactionWebServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(transactionMarshaller());
        webServiceTemplate.setUnmarshaller(transactionMarshaller());
        webServiceTemplate.setInterceptors(new ClientInterceptor[]{securityInterceptor()});
        return webServiceTemplate;
    }

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        
        // Set security credentials
        securityInterceptor.setSecurementActions("UsernameToken");
        securityInterceptor.setSecurementUsername(kycUsername);
        securityInterceptor.setSecurementPassword(kycPassword);
        securityInterceptor.setSecurementPasswordType("PasswordText");
        
        return securityInterceptor;
    }
}