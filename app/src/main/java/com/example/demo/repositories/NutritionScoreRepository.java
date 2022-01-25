package com.example.demo.repositories;

import com.example.demo.models.NutritionScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionScoreRepository extends JpaRepository<NutritionScore, Long> {

}
