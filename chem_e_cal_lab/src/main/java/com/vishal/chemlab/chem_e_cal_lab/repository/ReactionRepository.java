package com.vishal.chemlab.chem_e_cal_lab.repository;

import com.vishal.chemlab.chem_e_cal_lab.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    // Custom query using the correct database column names for native SQL
    @Query(value = "SELECT * FROM reaction WHERE compound1_id = :compound1Id AND compound2_id = :compound2Id", nativeQuery = true)
    Optional<Reaction> findReactionByElements(@Param("compound1Id") Long compound1Id, @Param("compound2Id") Long compound2Id);


}
