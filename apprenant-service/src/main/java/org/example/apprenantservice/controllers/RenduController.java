package org.example.apprenantservice.controllers;

import org.example.apprenantservice.dtos.RenduDTO;
import org.example.apprenantservice.services.RenduServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendu")
@CrossOrigin("*")
public class RenduController {

    private final RenduServices renduServices;

    public RenduController(RenduServices renduServices) {
        this.renduServices = renduServices;
    }

    @GetMapping
    public ResponseEntity<List<RenduDTO>> getAllRendus() {
        List<RenduDTO> rendus = renduServices.getAllRendus();
        return new ResponseEntity<>(rendus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RenduDTO> getRenduById(@PathVariable Long id) {
        RenduDTO rendu = renduServices.getRenduById(id);
        return new ResponseEntity<>(rendu, HttpStatus.OK);
    }

    @GetMapping("getRenduCount/{id}")
    public ResponseEntity total(@PathVariable Long id) {
        Long count = renduServices.total(id);
        return new ResponseEntity(count, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RenduDTO> createRendu(@RequestBody RenduDTO renduDTO) {
        RenduDTO createdRendu = renduServices.createRendu(renduDTO);
        return new ResponseEntity<>(createdRendu, HttpStatus.CREATED);
    }

    @PostMapping("/{renduId}/add-competence/{competenceId}")
    public ResponseEntity<RenduDTO> addCompetenceToRendu(
            @PathVariable Long renduId,
            @PathVariable Long competenceId) {
        RenduDTO updatedRendu = renduServices.assignCompetenceToRendu(renduId, competenceId);
        return new ResponseEntity<>(updatedRendu, HttpStatus.OK);
    }

//    @PostMapping("/{competenceId}/assign-to-rendu/{renduId}")
//    public ResponseEntity<RenduDTO> assignCompetenceToBrief(
//            @PathVariable Long competenceId,
//            @PathVariable Long renduId) {
//        RenduDTO updatedRendu = renduServices.assignCompetenceToBrief(competenceId, renduId);
//        return new ResponseEntity<>(updatedRendu, HttpStatus.OK);
//    }

//    @PostMapping("/{renduId}/assign-to-brief/{briefId}")
//    public ResponseEntity<RenduDTO> assignRenduToBrief(
//            @PathVariable Long renduId,
//            @PathVariable Long briefId) {
//        RenduDTO updatedRendu = renduServices.assignRenduToBrief(renduId, briefId);
//        return new ResponseEntity<>(updatedRendu, HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<RenduDTO> updateRendu(@PathVariable Long id, @RequestBody RenduDTO renduDTO) {
        RenduDTO updatedRendu = renduServices.updateRendu(id, renduDTO);
        return new ResponseEntity<>(updatedRendu, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRendu(@PathVariable Long id) {
        renduServices.deleteRendu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}