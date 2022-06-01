package com.employe.planningemploye.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeCompetence {

    @PlanningId
    @Id
    @GeneratedValue
    private Long id;

    private  String nomType;

    @PlanningVariable(valueRangeProviderRefs = "employeRange")
    @ManyToOne
    private  Employe employe;

    @PlanningVariable(valueRangeProviderRefs = "competenceRange")
    @ManyToOne
    private Competence competence;

    public TypeCompetence(String nomType, Employe employe, Competence competence) {
        this.nomType = nomType;
        this.employe = employe;
        this.competence = competence;
    }

    public String toString(){

        return nomType + "(" + id + ")" ;
    }
}
