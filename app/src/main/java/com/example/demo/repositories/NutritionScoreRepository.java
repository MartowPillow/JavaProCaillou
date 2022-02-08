package com.example.demo.repositories;

import com.example.demo.models.NutritionScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionScoreRepository extends JpaRepository<NutritionScore, Long> {

    @Query("SELECT ns.classe FROM NutritionScore ns WHERE ns.lowerBound <= ?1 and ns.upperBound >= ?1")
    String getClasse(int nutriscore);

    @Query("SELECT ns.color FROM NutritionScore ns WHERE ns.lowerBound <= ?1 and ns.upperBound >= ?1")
    String getColor(int nutriscore);

}
