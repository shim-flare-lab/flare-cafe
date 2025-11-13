package com.flarecafe.feature.menu.application.mapper;

import com.flarecafe.feature.menu.application.dto.response.IngredientResponseDto;
import com.flarecafe.feature.menu.domain.model.Ingredient;

import java.util.List;

public class IngredientMapper {
  public static IngredientResponseDto toResponseDto(Ingredient ingredient) {
    return new IngredientResponseDto(ingredient.getUniqueId());
  }

  public static List<IngredientResponseDto> toResponseDtoList(List<Ingredient> ingredients) {
    return ingredients.stream()
      .map(ingredient -> new IngredientResponseDto(ingredient.getUniqueId()))
      .toList();
  }
}
