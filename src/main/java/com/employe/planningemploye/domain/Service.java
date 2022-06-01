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
public class Service {

    @PlanningId
    @Id
    @GeneratedValue
    private Long Id;

    private String nomService;

    public Service(String nomService) {
        this.nomService = nomService;
    }

    public String toString(){

        return nomService;
    }
}
