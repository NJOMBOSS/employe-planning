package com.employe.planningemploye.persistence;

import com.employe.planningemploye.domain.TypeCompetence;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TypeCompetenceRepository extends PagingAndSortingRepository<TypeCompetence, Long> {

    List<TypeCompetence> findAll();

}
