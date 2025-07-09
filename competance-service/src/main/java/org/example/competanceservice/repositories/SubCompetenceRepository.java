package org.example.competanceservice.repositories;

import org.example.competanceservice.entities.SubCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCompetenceRepository extends JpaRepository<SubCompetence, Long> {
    List<SubCompetence> findAllByCompetence_Id(Long id);

}
