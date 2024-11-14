package com.vishal.chemlab.chem_e_cal_lab.service;

import com.vishal.chemlab.chem_e_cal_lab.model.Reaction;
import com.vishal.chemlab.chem_e_cal_lab.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReactionService
{
    @Autowired
    private ReactionRepository reactionRepository;

    public Optional<Reaction> findReaction(Long compound1Id, Long compound2Id)
    {
        // Call the new repository method to find the reaction by element IDs
        return reactionRepository.findReactionByElements(compound1Id, compound2Id);
    }
}
