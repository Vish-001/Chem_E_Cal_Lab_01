package com.example.chemecallab.controller;


import com.example.chemecallab.model.Element;
import com.example.chemecallab.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/element")
public class ElementController {
    @Autowired
    ElementService elementService;

    @GetMapping("/allElements")
    public List<Element> getAllElements() {
        return elementService.getAllElement();
    }

    @PostMapping("/add")
    public Element addElement(@RequestBody Element element) {
        return elementService.addElement(element);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteElement(@PathVariable Integer id) {
        elementService.deleteElement(id);
        return "Element and related reactions deleted successfully!";
    }
}

