package com.flarecafe.feature.promotion.domain.discount;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.promotion.domain.DiscountPolicy;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import org.springframework.stereotype.Component;

@Component
public class AmountDiscountPolicy implements DiscountPolicy {

  private final DiscountType discountType = DiscountType.AMOUNT;

  @Override
  public Money discount(Promotion promotion, Money money) {
    return money.minus(promotion.getDiscountAmount());
  }

  @Override
  public DiscountType getDiscountType() {
    return discountType;
  }
  
}
