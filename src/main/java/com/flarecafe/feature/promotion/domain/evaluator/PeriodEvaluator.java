package com.flarecafe.feature.promotion.domain.evaluator;

import com.flarecafe.feature.promotion.domain.PromotionConditionEvaluator;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.ConditionType;

import java.time.LocalDateTime;

public class PeriodEvaluator implements PromotionConditionEvaluator {
  
  private final ConditionType conditionType = ConditionType.PERIOD;

  @Override
  public boolean evaluate(Promotion promotion, String menu){
    return promotion.getPromotionPeriod().isInRange(LocalDateTime.now());
  }

  @Override
  public boolean supports(ConditionType conditionType) {
    return this.conditionType == conditionType;
  }
}
