package org.example.competanceservice.controllers;

import org.example.competanceservice.dtos.SubCompetenceDTO;
import org.example.competanceservice.services.SubCompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subCompetence")
public class SubCompetenceController {
    private final SubCompetenceService service;

    public SubCompetenceController(SubCompetenceService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<SubCompetenceDTO> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public SubCompetenceDTO addSubCompetence(@RequestBody SubCompetenceDTO dto){
        return service.addSubCompetence(dto);
    }

    @PutMapping("/update/{id}")
    public SubCompetenceDTO updateSubCompetence(@PathVariable Long id, @RequestBody SubCompetenceDTO dto){
        return service.updateSubCompetence(id, dto);
    }

    @PatchMapping("/validate/{id}")
    public SubCompetenceDTO validateSubCompetence(
            @PathVariable Long id,
            @RequestParam boolean isValid){
        return service.validate(id, isValid);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubCompetence(@PathVariable Long id){
        service.deleteSubCompetence(id);
    }
}
