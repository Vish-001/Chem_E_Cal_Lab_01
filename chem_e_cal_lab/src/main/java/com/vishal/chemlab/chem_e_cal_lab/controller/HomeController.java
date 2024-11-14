package com.vishal.chemlab.chem_e_cal_lab.controller;

import com.vishal.chemlab.chem_e_cal_lab.model.Compound;
import com.vishal.chemlab.chem_e_cal_lab.model.Reaction;
import com.vishal.chemlab.chem_e_cal_lab.service.CompoundService;
import com.vishal.chemlab.chem_e_cal_lab.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private CompoundService compoundService;

    @Autowired
    private ReactionService reactionService;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("compounds", compoundService.getAllCompounds());
        return "home";
    }

    @PostMapping("/getReaction")
    public String getReaction(@RequestParam Long compound1Id, @RequestParam Long compound2Id, Model model) {
        Optional<Reaction> reaction = reactionService.findReaction(compound1Id, compound2Id);
        if (reaction.isPresent())
        {
            model.addAttribute("reaction", reaction.get());
        } else {
            model.addAttribute("message", "No reaction found for the given compound IDs.");
        }
        return "result";
    }


    @PostMapping("/getProducts")
    public String getProducts(Model model) {
        List<Compound> products = compoundService.getAllCompounds();
        model.addAttribute("products", products);
        return "result"; // You may want to return a different view for products
    }
}
