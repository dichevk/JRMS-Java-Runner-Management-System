package main.java.com.javarun.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import main.java.com.javarun.web.models.Event;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sponsors")
public class Viewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String passId; 
    private String name;
    private String businessEntity;
    private String country; 
    private String iban;
    @OneToMany(mappedBy = "Sponsor", cascade = CascadeType.REMOVE)
    private List<Event> events = new ArrayList<>();
}
