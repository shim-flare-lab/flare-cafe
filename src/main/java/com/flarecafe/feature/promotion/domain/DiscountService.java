package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.promotion.domain.model.Promotion;

public class DiscountService {
  
  private final DiscountPolicy discountPolicy;
  private final PromotionConditionEvaluator promotionConditionEvaluator;
  
  public DiscountService(DiscountPolicy discountPolicy, PromotionConditionEvaluator promotionConditionEvaluator) {
    this.discountPolicy = discountPolicy;
    this.promotionConditionEvaluator = promotionConditionEvaluator;
  }
  
  public Money discount(Promotion promotion, String menu) {
    
    // todo : menu로부터 가져올 것.
    Money money = Money.ZERO;

    if (promotionConditionEvaluator.evaluate(promotion, menu)) {
      return Money.ZERO;
    }
    
    return discountPolicy.discount(promotion, money);
  }
  
}
