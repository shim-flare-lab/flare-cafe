package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.promotion.domain.discount.DiscountTemplate;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Factory class to create DiscountTemplate instances based on the discount type of a promotion.
 */
@Component
public class DiscountTemplateFactory {

  private final Map<DiscountType, DiscountPolicy> policyMap;

  public DiscountTemplateFactory(List<DiscountPolicy> policies) {
    policyMap = policies.stream()
        .collect(Collectors.toMap(DiscountPolicy::getDiscountType, Function.identity()));
  }

  public DiscountTemplate create(Promotion promotion) {
    return new DiscountTemplate(policyMap.get(promotion.getDiscountType()));
  }
  
}
