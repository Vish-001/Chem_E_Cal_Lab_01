package com.example.chemecallab.dao;

import com.example.chemecallab.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementDao extends JpaRepository<Element,Integer>
{

}
