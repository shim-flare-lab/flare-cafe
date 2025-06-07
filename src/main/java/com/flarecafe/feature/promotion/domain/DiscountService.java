package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.generic.DomainService;
import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.menu.domain.model.Menu;
import com.flarecafe.feature.promotion.domain.discount.DiscountTemplate;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class DiscountService {

  private final DiscountTemplateFactory discountTemplateFactory;

  // todo : Menu를 Order로 변경 필요
  public Money applyDiscount(Promotion promotion, Menu menu) {
    DiscountTemplate discountTemplate = discountTemplateFactory.create(promotion);
    return discountTemplate.discount(promotion, menu);
  }

}
