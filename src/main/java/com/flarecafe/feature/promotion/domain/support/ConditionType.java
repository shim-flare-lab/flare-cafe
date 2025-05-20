package com.flarecafe.feature.promotion.domain.support;

import com.flarecafe.feature.promotion.domain.evaluator.EvaluationContext;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.model.PromotionCondition;

import java.time.LocalDateTime;
import java.util.function.BiFunction;

public enum ConditionType {
  
  PERIOD(
    (promotionCondition, context) -> promotionCondition.isInRange(LocalDateTime.now())
  ),
  MENU(
    (promotionCondition, context) -> promotionCondition.includesMenu(context.menu())
  ),
  CATEGORY(
    (promotionCondition, context) -> promotionCondition.includesCategory(context.category())
  ),
  
  ;
  
  private final BiFunction<PromotionCondition, EvaluationContext, Boolean> conditionEvaluator;

  ConditionType(BiFunction<PromotionCondition, EvaluationContext, Boolean> conditionEvaluator) {
    this.conditionEvaluator = conditionEvaluator;
  }

  public boolean evaluate(PromotionCondition promotionCondition, EvaluationContext context) {
    return this.conditionEvaluator.apply(promotionCondition, context);
  }
}
