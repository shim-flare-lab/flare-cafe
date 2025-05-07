package com.flarecafe.feature.promotion.domain.repository;

import com.flarecafe.feature.promotion.domain.model.Promotion;

import java.util.Optional;

public interface PromotionRepository {

  Promotion save(Promotion promotion);

  Optional<Promotion> findById(long id);
  
}
