package com.flarecafe.feature.promotion.infra;

import com.flarecafe.feature.promotion.domain.Promotion;
import com.flarecafe.feature.promotion.domain.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PromotionRepositoryImpl implements PromotionRepository {
  
  private final PromotionJpaRepository promotionJpaRepository;
  
  @Override
  public Promotion save(Promotion promotion) {
    return promotionJpaRepository.save(promotion);
  }

  @Override
  public Optional<Promotion> findById(long id) {
    return promotionJpaRepository.findById(id);
  }

}
