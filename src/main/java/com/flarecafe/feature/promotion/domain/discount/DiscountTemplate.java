package com.flarecafe.feature.promotion.domain.discount;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.promotion.domain.DiscountPolicy;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.model.PromotionCondition;

public class DiscountTemplate {

  private final DiscountPolicy discountPolicy;

  public DiscountTemplate(DiscountPolicy discountPolicy) {
    this.discountPolicy = discountPolicy;
  }
  
  public Money discount(Promotion promotion, String menu) {

    // todo : menu로부터 가져올 것.
    Money money = Money.ZERO;
    
    for (PromotionCondition promotionCondition : promotion.getPromotionConditions()) {
      if (promotionCondition.evaluate("category", menu)) { // todo : menu로부터 카테고리 가져올 것
        return discountPolicy.discount(promotion, money);
      }
    }
    
    return Money.ZERO;
  }
}