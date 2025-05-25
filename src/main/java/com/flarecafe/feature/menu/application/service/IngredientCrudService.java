package com.flarecafe.feature.menu.application.service;

import com.flarecafe.feature.menu.application.dto.request.CreateIngredientRequestDto;
import com.flarecafe.feature.menu.application.dto.request.UpdateIngredientRequestDto;
import com.flarecafe.feature.menu.domain.model.Ingredient;
import com.flarecafe.feature.menu.domain.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientCrudService {
  private final IngredientRepository ingredientRepository;

  public List<Ingredient> findAll() {
    return ingredientRepository.findAll();
  }

  public Ingredient findByUniqueId(String uniqueId) {
    return ingredientRepository.findByUniqueId(uniqueId).orElseThrow();
  }

  @Transactional
  public String create(CreateIngredientRequestDto request) {
    return ingredientRepository.save(Ingredient.builder()
      .name(request.getName())
      .createdUserId("1") //TODO: user구현후 수정
      .build());
  }

  @Transactional
  public String update(String uniqueId, UpdateIngredientRequestDto request) {
    Ingredient ingredient = ingredientRepository.findByUniqueId(uniqueId).orElseThrow();

    ingredient.update(request.getName(), "1"); //TODO: user구현후 수정

    return ingredientRepository.save(ingredient);
  }

  @Transactional
  public String delete(String uniqueId) {
    Ingredient ingredient = ingredientRepository.findByUniqueId(uniqueId).orElseThrow();

    ingredient.delete("1");  //TODO: user구현후 수정

    return ingredientRepository.save(ingredient);
  }
}
