package com.employe.planningemploye.domain;


import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

import java.util.List;

@PlanningSolution
public class Planification {

    @ValueRangeProvider(id="serviceRange")
    @ProblemFactCollectionProperty
    private List<Service> serviceList;

    @ValueRangeProvider(id="horaireRange")
    @ProblemFactCollectionProperty
    private List<Horaire> horaireList;

    @ValueRangeProvider(id="CompetenceRange")
    @ProblemFactCollectionProperty
    private List<Competence> competenceList;

    @PlanningEntityCollectionProperty
    private List<Employe> employeList;

    @PlanningScore
    private HardSoftScore score;

    private SolverStatus solverStatus;

    public Planification() {

    }

    public Planification(List<Service> serviceList, List<Horaire> horaireList, List<Competence> competenceList, List<Employe> employeList) {
        this.serviceList = serviceList;
        this.horaireList = horaireList;
        this.competenceList = competenceList;
        this.employeList = employeList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Horaire> getHoraireList() {
        return horaireList;
    }

    public void setHoraireList(List<Horaire> horaireList) {
        this.horaireList = horaireList;
    }

    public List<Employe> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<Employe> employeList) {
        this.employeList = employeList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public SolverStatus getSolverStatus() {
        return solverStatus;
    }

    public void setSolverStatus(SolverStatus solverStatus) {
        this.solverStatus = solverStatus;
    }

    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }
}

