package com.employe.planningemploye.persistence;

import com.employe.planningemploye.domain.Competence;
import com.employe.planningemploye.domain.Employe;
import com.employe.planningemploye.domain.Horaire;


import com.employe.planningemploye.domain.Service;
import com.employe.planningemploye.rest.PlanificationController;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class ProblemChangedRepositoryEventListener {

    @Autowired
    private PlanificationController planificationController;

    public void assertNotSolving(){
        if(planificationController.getSolverStatus() != SolverStatus.NOT_SOLVING){
            throw new IllegalStateException("The solver is solving. Please stop solving first.");
        }
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void horaireCreateSaveDelete(Horaire horaire){

        assertNotSolving();
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void serviceCreateSaveDelete(Service service){

        assertNotSolving();
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void competenceCreateSaveDelete(Competence competence){

        assertNotSolving();
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void empployeCreateSaveDelete(Employe employe){

        assertNotSolving();
    }
}
