package com.example.demo.repositories;

import com.example.demo.models.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {

    @Query("SELECT MAX(r.points) FROM Rule r WHERE r.name = ?1 AND r.minBound <= ?2")
    double getComponentPoints(String component, double value);

}
