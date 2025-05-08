package com.flarecafe.feature.promotion.domain;

import java.util.Optional;

public interface PromotionRepository {

  Promotion save(Promotion promotion);

  Optional<Promotion> findById(long id);
  
}
