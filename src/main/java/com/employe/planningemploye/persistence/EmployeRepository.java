package com.employe.planningemploye.persistence;

import com.employe.planningemploye.domain.Employe;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeRepository extends PagingAndSortingRepository<Employe,Long> {

    List<Employe> findAll();

}
