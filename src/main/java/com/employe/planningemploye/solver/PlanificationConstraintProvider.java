package com.employe.planningemploye.solver;

import com.employe.planningemploye.domain.Employe;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class PlanificationConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                // Hard constraints

                serviceConflict(constraintFactory),
                nomConflict(constraintFactory)
        };
    }

    Constraint serviceConflict(ConstraintFactory constraintFactory) {
        return constraintFactory
                // Select each pair of 2 diffent employe...
                .forEach(Employe.class)
                .join(Employe.class,Joiners.equal(Employe::getNom),
                        Joiners.equal((employe)-> employe.getHoraire().getJourSemaine()))
                                .reward("employe time efficiency",HardSoftScore.ONE_HARD);

    }

    Constraint nomConflict(ConstraintFactory constraintFactory) {

        return constraintFactory
                // Select each pair of 2 diffent employe...
                .forEachUniquePair(Employe.class,
                        // ... A la même horaire ...
                        Joiners.equal(Employe::getHoraire),
                        // ... Dans le même service
                        Joiners.equal(Employe::getService),
                        Joiners.equal(Employe::getCompetence))
                .penalize("service conflict", HardSoftScore.ONE_HARD);

    }
}
