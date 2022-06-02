package com.employe.planningemploye.rest;

import com.employe.planningemploye.domain.Planification;
import com.employe.planningemploye.persistence.PlanificationRepository;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/plannification")
public class PlanificationController {
    @Autowired
    private PlanificationRepository planificationRepository;

    @Autowired
    private SolverManager<Planification, Long> solverManager;

    @Autowired
    private ScoreManager<Planification, HardSoftScore> scoreManager;

    public SolverStatus getSolverStatus(){
        return solverManager.getSolverStatus(PlanificationRepository.SINGLETON_PLANIFICATION_ID);
    }

    @GetMapping()
    public Planification getPlanification(){

        SolverStatus solverStatus = getSolverStatus() ;
        Planification solution =planificationRepository.findById(PlanificationRepository.SINGLETON_PLANIFICATION_ID);
        scoreManager.updateScore(solution);
        solution.setSolverStatus(solverStatus);
        return  solution;
    }

    @PostMapping("/solve")
    public void solve(){
        solverManager.solveAndListen(PlanificationRepository.SINGLETON_PLANIFICATION_ID,
                planificationRepository::findById,
                planificationRepository::save);
    }

    @PostMapping("/stopSolving")
    public void stopSolving(){
        solverManager.terminateEarly(PlanificationRepository.SINGLETON_PLANIFICATION_ID);
    }
}
