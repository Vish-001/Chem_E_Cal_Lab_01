package com.vishal.chemlab.chem_e_cal_lab.service;

import com.vishal.chemlab.chem_e_cal_lab.model.Compound;
import com.vishal.chemlab.chem_e_cal_lab.repository.CompoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompoundService {

    @Autowired
    private CompoundRepository compoundRepository;

    public List<Compound> getAllCompounds()
    {
        return compoundRepository.findAll();
    }
}
