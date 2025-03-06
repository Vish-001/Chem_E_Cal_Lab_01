package com.example.chemecallab.controller;

import com.example.chemecallab.model.Element;
import com.example.chemecallab.model.Reaction;
import com.example.chemecallab.service.ElementService;
import com.example.chemecallab.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/web/reactions")
public class ReactionWebController {
    @Autowired
    private ReactionService reactionService;

    @Autowired
    private ElementService elementService;

    // Display all reactions
    @GetMapping
    public String listReactions(Model model) {
        model.addAttribute("reactions", reactionService.getAllReaction());
        return "reactions";
    }

    // Show form to add a new reaction
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("reaction", new Reaction());
        model.addAttribute("elements", elementService.getAllElement());
        return "add-reaction";
    }

    // Handle adding a new reaction
    @PostMapping("/add")
    public String addReaction(@ModelAttribute Reaction reaction, RedirectAttributes redirectAttributes) {
        String result = reactionService.addReaction(reaction);
        if (result.startsWith("Reaction added")) {
            redirectAttributes.addFlashAttribute("message", result);
        } else {
            redirectAttributes.addFlashAttribute("error", result);
        }
        return "redirect:/web/reactions";
    }

    // Delete a reaction by ID
    @GetMapping("/delete/{id}")
    public String deleteReaction(@PathVariable Integer id) {
        reactionService.deleteReaction(id);
        return "redirect:/web/reactions";
    }

    // Show form to find a reaction between two elements
    @GetMapping("/find")
    public String showFindReactionForm(Model model) {
        model.addAttribute("elements", elementService.getAllElement());
        return "find-reaction";
    }

    // Handle finding a reaction between two elements
    @PostMapping("/find")
    public String findReaction(@RequestParam Integer element1, @RequestParam Integer element2, Model model) {
        // Fetch all reactions
        List<Reaction> reactions = reactionService.getAllReaction();

        // Fetch the selected elements
        Element elementOne = elementService.getElementById(element1);
        Element elementTwo = elementService.getElementById(element2);

        // Find a reaction where the selected elements match eid_1 and eid_2 (order doesn't matter)
        Reaction foundReaction = reactions.stream()
                .filter(reaction ->
                        (reaction.getEid_1().equals(element1) && reaction.getEid_2().equals(element2)) ||
                                (reaction.getEid_1().equals(element2) && reaction.getEid_2().equals(element1)))
                .findFirst()
                .orElse(null);

        // Prepare the formatted reaction string
        String formattedReaction = null;
        if (foundReaction != null) {
            formattedReaction = elementOne.getFormula() + " + " + elementTwo.getFormula() + " → " + foundReaction.getFormula();
        }

        // Add results to the model
        model.addAttribute("elements", elementService.getAllElement());
        model.addAttribute("foundReaction", foundReaction);
        model.addAttribute("formattedReaction", formattedReaction);
        return "find-reaction";
    }
}