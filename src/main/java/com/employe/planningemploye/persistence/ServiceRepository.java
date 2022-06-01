package com.employe.planningemploye.persistence;

import com.employe.planningemploye.domain.Service;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ServiceRepository extends PagingAndSortingRepository<Service, Long> {

    List<Service> findAll();

}
