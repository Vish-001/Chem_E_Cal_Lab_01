package com.example.chemecallab.service;

import com.example.chemecallab.dao.ElementDao;
import com.example.chemecallab.model.Element;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementService {
    @Autowired
    private ElementDao elementDao;

    // Get all elements
    public List<Element> getAllElement() {
        return elementDao.findAll();
    }

    // Add a new element
    public Element addElement(Element element) {
        return elementDao.save(element);
    }

    // Delete an element by ID
    @Transactional
    public void deleteElement(Integer id) {
        elementDao.deleteById(id);
    }

    // Get an element by ID
    public Element getElementById(Integer id) {
        return elementDao.findById(id).orElseThrow(() -> new RuntimeException("Element not found"));
    }
}