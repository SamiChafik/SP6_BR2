package org.example.apprenantservice.repositories;

import org.example.apprenantservice.entities.Rendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RenduRepository extends JpaRepository<Rendu, Long> {
    @Query(value = "SELECT  COUNT(RENDU.ID) FROM RENDU WHERE RENDU.briefId = ?",
            nativeQuery = true)
    Long total(Long id);
//    Long CountRenduByBriefId(Long id);
}
