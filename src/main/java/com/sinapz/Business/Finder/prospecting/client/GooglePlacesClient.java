package com.sinapz.Business.Finder.prospecting.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class GooglePlacesClient {

    @Qualifier("googlePlacesRestClient")
    private final RestClient googlePlacesClient;

    public JsonNode search(String query) {

        return googlePlacesClient.post()
                .uri("/places:searchText")
                .header(
                        "X-Goog-FieldMask",
                        "places.displayName," +
                                "places.formattedAddress," +
                                "places.nationalPhoneNumber," +
                                "places.websiteUri"
                )
                .body(Map.of("textQuery", query))
                .retrieve()
                .body(JsonNode.class);
    }
}