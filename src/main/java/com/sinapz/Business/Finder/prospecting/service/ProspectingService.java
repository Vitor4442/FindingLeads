package com.sinapz.Business.Finder.prospecting.service;

import com.sinapz.Business.Finder.prospecting.client.GooglePlacesClient;
import com.sinapz.Business.Finder.prospecting.dto.ProspectingRequest;
import com.sinapz.Business.Finder.prospecting.dto.ProspectingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProspectingService {

    private final GooglePlacesClient googlePlacesClient;

    public List<ProspectingResponse> search(ProspectingRequest request) {

        String query = request.segment()
                + " em "
                + request.city();

        JsonNode result = googlePlacesClient.search(query);

        List<ProspectingResponse> companies = new ArrayList<>();

        JsonNode places = result.path("places");

        for (JsonNode place : places) {

            companies.add(new ProspectingResponse(
                    place.path("displayName")
                            .path("text").asText(null),

                    place.path("formattedAddress")
                            .asText(null),

                    place.path("nationalPhoneNumber")
                            .asText(null),

                    place.path("websiteUri")
                            .asText(null)
            ));
        }

        return companies;
    }
}