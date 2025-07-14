package org.example.competanceservice.controllers;

import org.example.competanceservice.dtos.LinkDto;
import org.example.competanceservice.dtos.LinkRequest;
import org.example.competanceservice.entities.BriefCompetence;
import org.example.competanceservice.services.BriefCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brief-competences")
public class BriefCompetenceController {

    @Autowired
    private BriefCompetenceService service;

    @PostMapping("/link")
    public BriefCompetence link(@RequestBody LinkDto Dto) {
        return service.link(Dto);
    }

    @GetMapping("/brief/{briefId}")
    public List<BriefCompetence> getByBrief(@PathVariable Long briefId) {
        return service.getByBrief(briefId);
    }

    @GetMapping("/competence/{competenceId}")
    public List<BriefCompetence> getByCompetence(@PathVariable Long competenceId) {
        return service.getByCompetence(competenceId);
    }
}
