package com.javarun.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javarun.web.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
