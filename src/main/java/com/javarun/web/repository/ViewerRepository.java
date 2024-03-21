package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javarun.web.models.Viewer;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Long>{
    
}
