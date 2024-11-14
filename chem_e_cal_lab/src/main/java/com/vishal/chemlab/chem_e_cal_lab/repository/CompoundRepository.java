package com.vishal.chemlab.chem_e_cal_lab.repository;

import com.vishal.chemlab.chem_e_cal_lab.model.Compound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompoundRepository extends JpaRepository<Compound, Long>
{
}
