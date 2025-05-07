package com.flarecafe.feature.promotion.domain.discount;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.promotion.domain.DiscountPolicy;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import org.springframework.stereotype.Component;

@Component
public class PercentageDiscountPolicy implements DiscountPolicy {
  
  private final DiscountType discountType = DiscountType.PERCENTAGE;

  @Override
  public Money discount(Promotion promotion, Money money) {
    Money discountAmount = money.applyPercentage(promotion.getDiscountPercentage());
    return money.minus(discountAmount);
  }

  @Override
  public DiscountType getDiscountType() {
    return discountType;
  }
  
}
