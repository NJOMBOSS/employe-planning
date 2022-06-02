package com.employe.planningemploye.persistence;

import com.employe.planningemploye.domain.Employe;
import com.employe.planningemploye.domain.Planification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PlanificationRepository {

    public static final Long SINGLETON_PLANIFICATION_ID = 1L;

    @Autowired
    private CompetenceRepository comptetenceRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private  HoraireRepository horaireRepository;

    @Autowired
    private  ServiceRepository serviceRepository;


    public Planification findById(Long id){
        if(!SINGLETON_PLANIFICATION_ID.equals(id)){
            throw new IllegalStateException("Il n' a pas une planification avec l'identifiant (" + id + ").");
        }

        return new Planification(
                serviceRepository.findAll(),
                horaireRepository.findAll(),
                comptetenceRepository.findAll(),
                employeRepository.findAll());

       }

     public void save(Planification planification){
        for(Employe employe: planification.getEmployeList()){
            employeRepository.save(employe);
        }
     }

}
