package com.javarun.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.com.javarun.web.models.History;
import main.java.com.javarun.web.models.Team;
import main.java.com.javarun.web.models.Event;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "runners")
public class Runner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthDate;
    private String info;
    private String identityId;
    private Integer number;
    @OneToOne
    private History history;
    private Team team;
    private List<Event> events;
}