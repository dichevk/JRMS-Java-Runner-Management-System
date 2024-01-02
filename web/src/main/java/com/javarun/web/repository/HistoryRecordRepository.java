package com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javarun.web.model.HistoryRecord;

public interface HistoryRecordRepository extends JpaRepository<HistoryRecord, Long>{
    
}
