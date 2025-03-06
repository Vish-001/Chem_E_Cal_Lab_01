package com.example.chemecallab.service;

import com.example.chemecallab.dao.ElementDao;
import com.example.chemecallab.dao.ReactionDao;
import com.example.chemecallab.model.Reaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionService {
    @Autowired
    ReactionDao reactionDao;

    @Autowired
    ElementDao elementDao;

    public List<Reaction> getAllReaction() {
        return reactionDao.findAll();
    }

    public String addReaction(Reaction reaction) {
        // Ensure both elements exist
        if (elementDao.existsById(reaction.getEid_1()) && elementDao.existsById(reaction.getEid_2())) {
            reactionDao.save(reaction);
            return "Reaction added successfully!";
        }
        return "One or both elements do not exist!";
    }

    public void deleteReaction(Integer id) {
        reactionDao.deleteById(id);
    }
}