package com.flarecafe.feature.promotion.domain;

import com.flarecafe.config.DataSourceConfig;
import com.flarecafe.config.JpaConfig;
import com.flarecafe.feature.promotion.infra.PromotionJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Import({DataSourceConfig.class, JpaConfig.class})
class PromotionRepositoryTest {

  @Autowired
  PromotionJpaRepository promotionJpaRepository;
  
  @BeforeEach
  @Transactional
  void setUp() {
    Promotion promotion = new Promotion();
    promotion.setCreatedUserId("test");
    promotion.setModifiedUserId("test");
    promotionJpaRepository.save(promotion);
  }
  
  @Test
  @Transactional
  void update() {

    Promotion promotion = promotionJpaRepository.findById(1L).orElseThrow();
    promotion.delete("shs");
    
    System.out.println(promotion);
    
  }
  
}