package com.vishal.chemlab.chem_e_cal_lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long compound1Id;
    private Long compound2Id;
    private String reactionFormula;
    private Long resultantCompoundId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompound1Id() {
        return compound1Id;
    }

    public void setCompound1Id(Long compound1Id) {
        this.compound1Id = compound1Id;
    }

    public Long getCompound2Id() {
        return compound2Id;
    }

    public void setCompound2Id(Long compound2Id) {
        this.compound2Id = compound2Id;
    }

    public String getReactionFormula() {
        return reactionFormula;
    }

    public void setReactionFormula(String reactionFormula) {
        this.reactionFormula = reactionFormula;
    }

    public Long getResultantCompoundId() {
        return resultantCompoundId;
    }

    public void setResultantCompoundId(Long resultantCompoundId) {
        this.resultantCompoundId = resultantCompoundId;
    }
}
