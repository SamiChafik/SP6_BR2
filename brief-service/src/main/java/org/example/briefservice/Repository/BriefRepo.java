package org.example.briefservice.Repository;


import org.example.briefservice.Entity.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BriefRepo extends JpaRepository<Brief, Long> {


}
