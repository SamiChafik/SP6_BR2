package org.example.apprenantservice.feign;

import org.example.apprenantservice.dtos.CompetenceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "competence-service",
        url = "http://localhost:8083/competence")
public interface CompetenceServiceClient {
    @GetMapping("/getById/{id}")
    public CompetenceDTO getCompetenceById(@PathVariable Long id);
}
