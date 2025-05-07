package com.flarecafe.feature.promotion.domain;

import com.flarecafe.config.DataSourceConfig;
import com.flarecafe.config.JpaConfig;
import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.generic.Status;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.model.PromotionType;
import com.flarecafe.feature.promotion.infra.PromotionJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({DataSourceConfig.class, JpaConfig.class})
class PromotionRepositoryTest {

  @Autowired
  PromotionJpaRepository promotionJpaRepository;
  
  @BeforeEach
  void setUp() {
    save();
  }

  void save() {
    Promotion p = new Promotion();
    p.update("promotion", "description", 0, PromotionType.AMOUNT, Money.ZERO, 10);
    p.setCreatedUserId("createUser");
    p.setModifiedUserId("createUser");
    promotionJpaRepository.save(p);
  }

  @Test
  void deleteTest() throws Exception {

    // given
    String modifiedUserId = "bright-flare";
    Promotion promotion = promotionJpaRepository.findById(1L).orElseThrow();
    
    // when
    promotion.delete(modifiedUserId);
    
    // then
    assertEquals(Status.DELETED, promotion.getStatus());
    assertEquals(modifiedUserId, promotion.getModifiedUserId());

  }
  
}