package main.java.com.javarun.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javarun.web.models.Team;

@Repository
public interface EventRepository extends JpaRepository<Team, Long>{
    
}
