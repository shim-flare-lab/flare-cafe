package com.flarecafe.feature.menu.infra.repository.ingredient;

import com.flarecafe.feature.menu.domain.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientJpaRepository extends JpaRepository<Ingredient, Long> {
  Optional<Ingredient> findByUniqueId(String uniqueId);
}
