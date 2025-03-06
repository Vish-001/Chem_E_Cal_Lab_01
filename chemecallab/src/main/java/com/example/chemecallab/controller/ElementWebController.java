package com.example.chemecallab.controller;

import com.example.chemecallab.model.Element;
import com.example.chemecallab.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Correct import
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/elements")
public class ElementWebController {
    @Autowired
    private ElementService elementService;

    @GetMapping
    public String listElements(Model model) {
        model.addAttribute("elements", elementService.getAllElement());
        return "elements";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("element", new Element());
        return "add-element";
    }

    @PostMapping("/add")
    public String addElement(@ModelAttribute Element element) {
        elementService.addElement(element);
        return "redirect:/web/elements";
    }

    @GetMapping("/delete/{id}")
    public String deleteElement(@PathVariable Integer id) {
        elementService.deleteElement(id);
        return "redirect:/web/elements";
    }
}