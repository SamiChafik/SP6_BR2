package org.example.competanceservice.repositories;

import org.example.competanceservice.entities.BriefCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BriefCompetenceRepository extends JpaRepository<BriefCompetence, Long> {

    List<BriefCompetence> findByBriefId(Long briefId);
    List<BriefCompetence> findByCompetenceId(Long competenceId);
}
