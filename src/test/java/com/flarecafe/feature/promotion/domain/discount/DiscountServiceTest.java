package com.flarecafe.feature.promotion.domain.discount;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.generic.TimeInterval;
import com.flarecafe.feature.promotion.domain.DiscountService;
import com.flarecafe.feature.promotion.domain.evaluator.MenuEvaluator;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

  private final DiscountService discountService = new DiscountService(new AmountDiscountPolicy(), new MenuEvaluator());

  // todo : menu를 Menu로 바꾸어야 한다.
  @Test
  @Disabled
  void fixedAmountDiscount() {

    // given
    Promotion promotion = new Promotion();
    promotion.update("test", "test", DiscountType.AMOUNT, Money.of(10000), 15, TimeInterval.UN_LIMITED, "bright-flare");
    
    // when
    Money money = discountService.discount(promotion, "menu");

    // then
    assertEquals(money, Money.of(10000));
    
  }
  
  // todo : menu를 Menu로 바꾸어야 한다.
  @Test
  @Disabled
  void percentageDiscount() {

    // given
    Promotion promotion = new Promotion();
    promotion.update("test", "test", DiscountType.PERCENTAGE, Money.of(10000), 15, TimeInterval.UN_LIMITED, "bright-flare");
    
    // when
    Money money = discountService.discount(promotion, "menu");

    // then
    assertEquals(money, Money.of(17000));
    
  }
  
}