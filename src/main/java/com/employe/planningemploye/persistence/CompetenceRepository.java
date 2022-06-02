package com.employe.planningemploye.persistence;

import com.employe.planningemploye.domain.Competence;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CompetenceRepository extends PagingAndSortingRepository<Competence,Long> {

    List<Competence> findAll();

}
