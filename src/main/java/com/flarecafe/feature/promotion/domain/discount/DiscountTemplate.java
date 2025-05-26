package com.flarecafe.feature.promotion.domain.discount;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.menu.domain.model.Menu;
import com.flarecafe.feature.promotion.domain.DiscountPolicy;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.model.PromotionCondition;

public class DiscountTemplate {

  private final DiscountPolicy discountPolicy;

  public DiscountTemplate(DiscountPolicy discountPolicy) {
    this.discountPolicy = discountPolicy;
  }
  
  // todo : Menu를 Order로 변경 필요. Order에서 메뉴 + 추가금 합산 금액을 제공할 것.
  public Money discount(Promotion promotion, Menu menu) {

//    Money money = menu.calculateTotalPrice(); // todo : Order에서 메뉴 + 추가금 합산 금액을 제공할 것.
    Money money = Money.ZERO;
    
    for (PromotionCondition promotionCondition : promotion.getPromotionConditions()) {
      if (promotionCondition.evaluate(menu)) {
        return discountPolicy.discount(promotion, money);
      }
    }
    
    return Money.ZERO;
  }
}