package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.DiscountType;

public interface DiscountPolicy {

  Money discount(Promotion promotion, Money money);
  
  DiscountType getDiscountType();
  
}
