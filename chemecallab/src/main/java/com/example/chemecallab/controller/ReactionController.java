package com.example.chemecallab.controller;

import com.example.chemecallab.model.Reaction;
import com.example.chemecallab.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reaction")
public class ReactionController {
    @Autowired
    ReactionService reactionService;

    @GetMapping("/allReactions")
    public List<Reaction> getAllReactions() {
        return reactionService.getAllReaction();
    }

    @PostMapping("/add")
    public String addReaction(@RequestBody Reaction reaction) {
        return reactionService.addReaction(reaction);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReaction(@PathVariable Integer id) {
        reactionService.deleteReaction(id);
        return "Reaction deleted successfully!";
    }
}
