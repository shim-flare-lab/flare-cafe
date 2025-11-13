package com.flarecafe.feature.menu.domain.repository;

import com.flarecafe.feature.menu.domain.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {
  List<Ingredient> findAll();
  Optional<Ingredient> findById(long id);
  Optional<Ingredient> findByUniqueId(String uniqueId);
  String save(Ingredient ingredient);
}
