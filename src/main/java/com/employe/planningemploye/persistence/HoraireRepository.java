package com.employe.planningemploye.persistence;

import com.employe.planningemploye.domain.Horaire;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HoraireRepository extends PagingAndSortingRepository<Horaire,Long> {

    List<Horaire> findAll();

}
