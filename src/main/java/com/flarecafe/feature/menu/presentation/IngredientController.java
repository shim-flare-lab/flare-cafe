package com.flarecafe.feature.menu.presentation;

import com.flarecafe.common.response.SuccessListResponse;
import com.flarecafe.common.response.SuccessResponse;
import com.flarecafe.feature.menu.application.dto.request.CreateIngredientRequestDto;
import com.flarecafe.feature.menu.application.dto.request.UpdateIngredientRequestDto;
import com.flarecafe.feature.menu.application.dto.response.IngredientResponseDto;
import com.flarecafe.feature.menu.application.mapper.IngredientMapper;
import com.flarecafe.feature.menu.application.service.IngredientCrudService;
import com.flarecafe.feature.menu.domain.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {
  private final IngredientCrudService IngredientCrudService;

  @GetMapping
  public SuccessListResponse<IngredientResponseDto> getAll() {
    List<Ingredient> ingredients = IngredientCrudService.findAll();
    List<IngredientResponseDto> responseDtos = IngredientMapper.toResponseDtoList(ingredients);

    return SuccessListResponse.ok(responseDtos);
  }

  @GetMapping("/{id}")
  public SuccessResponse<IngredientResponseDto> getById(@PathVariable String uniqueId) {
    Ingredient ingredient = IngredientCrudService.findByUniqueId(uniqueId);
    IngredientResponseDto responseDto = IngredientMapper.toResponseDto(ingredient);

    return SuccessResponse.ok(responseDto);
  }

  @PostMapping
  public SuccessResponse<IngredientResponseDto> create(@RequestBody CreateIngredientRequestDto request) {
    String createdUniqueId = IngredientCrudService.create(request);

    return SuccessResponse.ok(IngredientResponseDto.onlyUniqueId(createdUniqueId));
  }

  @PutMapping("/{id}")
  public SuccessResponse<IngredientResponseDto> update(@PathVariable String uniqueId, @RequestBody UpdateIngredientRequestDto request) {
    String updatedUniqueId = IngredientCrudService.update(uniqueId, request);

    return SuccessResponse.ok(IngredientResponseDto.onlyUniqueId(updatedUniqueId));
  }

  @DeleteMapping("/{id}")
  public SuccessResponse<IngredientResponseDto> delete(@PathVariable String uniqueId) {
    String deletedUniqueId = IngredientCrudService.delete(uniqueId);

    return SuccessResponse.ok(IngredientResponseDto.onlyUniqueId(deletedUniqueId));
  }
}