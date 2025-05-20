package com.flarecafe.feature.promotion.domain.discount;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.generic.TimeInterval;
import com.flarecafe.feature.promotion.domain.DiscountTemplateFactory;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DiscountTemplateTest {

  private DiscountTemplateFactory discountTemplateFactory;
  private final AmountDiscountPolicy amountDiscountPolicy = new AmountDiscountPolicy();
  private final PercentageDiscountPolicy percentageDiscountPolicy = new PercentageDiscountPolicy();
  
  @BeforeEach
  void setUp() {
    discountTemplateFactory = new DiscountTemplateFactory(List.of(amountDiscountPolicy, percentageDiscountPolicy));
  }

  // todo : menu를 Menu로 바꾸어야 한다.
  @Test
  @Disabled
  void fixedAmountDiscount() {

    // given
    Promotion promotion = Promotion.fixture();
    
    // when
    DiscountTemplate discountTemplate = discountTemplateFactory.create(promotion);
    Money money = discountTemplate.discount(promotion, "menu");

    // then
    assertEquals(money, Money.ZERO);
    
  }
  
  // todo : menu를 Menu로 바꾸어야 한다.
  @Test
  @Disabled
  void percentageDiscount() {

    // given
    Promotion promotion = new Promotion();
    promotion.update("test", "test", DiscountType.PERCENTAGE, Money.of(10000), 15, TimeInterval.UN_LIMITED, "bright-flare");
    
    // when
    DiscountTemplate discountTemplate = discountTemplateFactory.create(promotion);
    Money money = discountTemplate.discount(promotion, "menu");

    // then
    assertEquals(money, Money.of(17000));
    
  }
  
}