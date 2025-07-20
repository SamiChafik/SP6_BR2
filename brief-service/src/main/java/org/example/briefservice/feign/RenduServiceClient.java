package org.example.briefservice.feign;

import org.example.briefservice.Dto.RenduDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "rendu-service",
        url = "http://localhost:8081/rendu")
public interface RenduServiceClient {
    @GetMapping("/{id}")
    public ResponseEntity<RenduDTO> getRenduById(@PathVariable Long id);

    @GetMapping("getRenduCount/{id}")
    public ResponseEntity total(@PathVariable Long id);
}
