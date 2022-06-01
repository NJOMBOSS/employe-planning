package com.employe.planningemploye.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horaire {

    @PlanningId
    @Id
    @GeneratedValue
    private Long id;

    private DayOfWeek jourSemaine;

    private LocalTime heureDebut;

    private LocalTime heureFin;

    public Horaire(DayOfWeek jourSemaine, LocalTime heureDebut, LocalTime heureFin) {
        this.jourSemaine = jourSemaine;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public String toString(){

        return jourSemaine + " " + heureDebut + " " + heureFin;
    }
}
