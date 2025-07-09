package org.example.briefservice.Repository;


import org.example.briefservice.Entity.Brief;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BriefRepo extends JpaRepository<Brief, Long> {
}
