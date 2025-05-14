package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.generic.DomainService;
import com.flarecafe.feature.promotion.domain.evaluator.CategoryEvaluator;
import com.flarecafe.feature.promotion.domain.model.PromotionCondition;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

@DomainService
@RequiredArgsConstructor
public class PromotionConditionFactory {

  private final List<PromotionConditionEvaluator> evaluators;
  
  public PromotionConditionEvaluator resolve(PromotionCondition promotionCondition) {
    
    switch (promotionCondition.getConditionType()) {
      case CATEGORY: new CategoryEvaluator(promotionCondition.getPromotionCategories())
    }
    
    return evaluators.stream()
      .filter(evaluator -> evaluator.supports(promotionCondition.getConditionType()))
      .findFirst()
      .orElseThrow(() -> new NoSuchElementException("promotion condition evaluator not found"));
  }
  
}
