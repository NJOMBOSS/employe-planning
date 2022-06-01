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
public class Employe {

    @PlanningId
    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String prenom;

    @PlanningVariable(valueRangeProviderRefs = "serviceRange")
    @ManyToOne
    private Service service;

    @PlanningVariable(valueRangeProviderRefs = "horaireRange")
    @ManyToOne
    private Horaire horaire;

    public Employe(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String toString(){
        return nom + prenom + "(" + id + ")" ;
    }
}
