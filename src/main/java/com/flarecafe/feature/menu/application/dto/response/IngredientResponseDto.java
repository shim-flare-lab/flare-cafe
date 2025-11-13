package com.flarecafe.feature.menu.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class IngredientResponseDto {
  public String uniqueId;

  public static IngredientResponseDto onlyUniqueId(String uniqueId) {
    return new IngredientResponseDto(uniqueId);
  }
}
