package com.employe.planningemploye.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competence {

    @PlanningId
    @Id
    @GeneratedValue
     private Long id;

     private String nomCompetence;

    public Competence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    public String toString(){

        return nomCompetence;
    }

}
