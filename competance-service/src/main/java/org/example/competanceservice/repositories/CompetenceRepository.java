package org.example.competanceservice.repositories;

import org.example.competanceservice.dtos.CompetenceDTO;
import org.example.competanceservice.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {

    Competence getCompetenceById(Long id);
}
