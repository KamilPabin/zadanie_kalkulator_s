package com.pabin.kamil.zadanie_kalkulator_s.configuration;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NBPRestTemplateConfig {

    @Bean
    public RestTemplate nbpRestTemplate(
            @Value("${NBPClient.connectTimeout}") int connectionTimeout,
            @Value("${NBPClient.connectionRequestTimeout}") int connectionRequestTimeout,
            @Value("${NBPClient.readTimeout}") int readTimeout) {
        RestTemplate restTemplate = new RestTemplate(httpFactory(
                connectionTimeout,
                connectionRequestTimeout,
                readTimeout));
        return restTemplate;
    }

    private HttpComponentsClientHttpRequestFactory httpFactory(int connectionTimeout,
                                                               int connectionRequestTimeout,
                                                               int readTimeout) {
        HttpComponentsClientHttpRequestFactory requestConfig = new HttpComponentsClientHttpRequestFactory();
        requestConfig.setConnectTimeout(connectionTimeout);
        requestConfig.setConnectionRequestTimeout(connectionRequestTimeout);
        requestConfig.setReadTimeout(readTimeout);
        requestConfig.setHttpClient(httpClient());
        return requestConfig;
    }

    private org.apache.http.client.HttpClient httpClient() {
        return HttpClientBuilder.create()
                .setMaxConnTotal(10)
                .setMaxConnPerRoute(5)
                .build();
    }

}
