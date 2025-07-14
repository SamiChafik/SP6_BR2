package org.example.competanceservice.services;


import org.example.competanceservice.dtos.LinkDto;
import org.example.competanceservice.entities.BriefCompetence;
import org.example.competanceservice.repositories.BriefCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BriefCompetenceService {

    @Autowired
    private  BriefCompetenceRepository repository;


    public BriefCompetence link(LinkDto Dto){
        BriefCompetence bc = new BriefCompetence();
        bc.setBriefId(Dto.getBriefId());
        bc.setCompetenceId(Dto.getCompetenceId());
        return repository.save(bc);
    }

    public List<BriefCompetence> getByBrief(Long briefId) {
        return repository.findByBriefId(briefId);
    }

    public List<BriefCompetence> getByCompetence(Long competenceId) {
        return repository.findByCompetenceId(competenceId);
    }
}

