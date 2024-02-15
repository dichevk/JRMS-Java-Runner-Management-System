package com.javarun.web.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.javarun.web.models.HistoryRecord;
import main.java.com.javarun.web.models.Runner;
import main.java.com.javarun.web.models.Team;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "histories")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Runner runner;
    private Team team;
    private List<HistoryRecord> historyRecords = new ArrayList<HistoryRecord>();
}
