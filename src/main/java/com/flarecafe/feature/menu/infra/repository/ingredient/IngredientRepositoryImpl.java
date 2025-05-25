package com.flarecafe.feature.menu.infra.repository.ingredient;

import com.flarecafe.feature.menu.domain.model.Ingredient;
import com.flarecafe.feature.menu.domain.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class IngredientRepositoryImpl implements IngredientRepository {
  private final IngredientJpaRepository ingredientJpaRepository;


  @Override
  public List<Ingredient> findAll() {
    return ingredientJpaRepository.findAll();
  }

  @Override
  public Optional<Ingredient> findById(long id) {
    return ingredientJpaRepository.findById(id);
  }

  public Optional<Ingredient> findByUniqueId(String uniqueId) {
    return ingredientJpaRepository.findByUniqueId(uniqueId);
  }

  @Override
  public String save(Ingredient ingredient) {
    Ingredient updatedIngredient = ingredientJpaRepository.save(ingredient);

    return updatedIngredient.getUniqueId();
  }
}
