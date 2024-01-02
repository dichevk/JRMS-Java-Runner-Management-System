package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javarun.web.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    
}
