package com.example.chemecallab.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;

    private Integer eid_1; // Element 1 ID
    private Integer eid_2; // Element 2 ID

    private String name;
    private String formula;
    private String characteristics;
}

