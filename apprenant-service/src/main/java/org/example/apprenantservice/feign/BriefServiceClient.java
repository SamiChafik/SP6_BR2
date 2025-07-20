package org.example.apprenantservice.feign;

import org.example.apprenantservice.config.FeignConfig;
import org.example.apprenantservice.dtos.BriefDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "brief-service",
        url = "http://localhost:8082")
public interface BriefServiceClient {

    @GetMapping("/brief/{id}")
    public BriefDto getBriefById(@PathVariable Long id);
}
