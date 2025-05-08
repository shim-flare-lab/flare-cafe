package com.flarecafe.feature.promotion.infra;

import com.flarecafe.feature.promotion.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionJpaRepository extends JpaRepository<Promotion, Long> {
  
}
