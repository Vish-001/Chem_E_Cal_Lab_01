package com.example.chemecallab.dao;

import com.example.chemecallab.model.Reaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionDao extends JpaRepository<Reaction, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Reaction r WHERE r.eid_1 = ?1 OR r.eid_2 = ?1")
    void deleteByEid1OrEid2(Integer eid1, Integer eid2);
}
