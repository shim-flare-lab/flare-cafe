package com.flarecafe.feature.promotion.domain.evaluator;

import com.flarecafe.feature.promotion.domain.support.ConditionType;
import com.flarecafe.feature.promotion.domain.model.PromotionCondition;
import com.flarecafe.feature.promotion.domain.PromotionConditionEvaluator;

import java.time.LocalDateTime;

public class PeriodEvaluator implements PromotionConditionEvaluator {
  
  private final ConditionType conditionType = ConditionType.PERIOD;

  @Override
  public boolean evaluate(PromotionCondition promotionCondition) {
    return promotionCondition.isInRange(LocalDateTime.now());
  }
  
}
