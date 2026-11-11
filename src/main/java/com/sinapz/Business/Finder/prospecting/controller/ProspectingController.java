package com.sinapz.Business.Finder.prospecting.controller;

import com.sinapz.Business.Finder.prospecting.dto.ProspectingRequest;
import com.sinapz.Business.Finder.prospecting.dto.ProspectingResponse;
import com.sinapz.Business.Finder.prospecting.service.ProspectingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prospecting")
@RequiredArgsConstructor
public class ProspectingController {

    private final ProspectingService prospectingService;

    @PostMapping("/search")
    public ResponseEntity<List<ProspectingResponse>> search(@RequestBody ProspectingRequest request) {
        return ResponseEntity.ok(prospectingService.search(request));
    }
}