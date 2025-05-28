package com.flarecafe.feature.promotion.presentation.dto;

import com.flarecafe.feature.promotion.domain.support.DiscountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CreatePromotion(

  @NotNull
  DiscountType discountType,

  @NotBlank
  String name,

  @NotBlank
  String description,

  BigDecimal discountAmount,

  Integer discountPercentage,

  @NotNull
  LocalDateTime startAt,

  @NotNull
  LocalDateTime endAt

) {

}

