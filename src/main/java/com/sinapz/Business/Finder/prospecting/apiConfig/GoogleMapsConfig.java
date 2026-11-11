package com.sinapz.Business.Finder.prospecting.apiConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class GoogleMapsConfig {

    @Value("${GOOGLE_MAPS_API_KEY}")
    private String apiKey;

    @Bean
    public RestClient googlePlacesRestClient() {
        return RestClient.builder()
                .baseUrl("https://places.googleapis.com/v1")
                .defaultHeader("X-Goog-Api-Key", apiKey)
                .build();
    }
}