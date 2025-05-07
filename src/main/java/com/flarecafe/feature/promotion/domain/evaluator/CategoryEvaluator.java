package com.flarecafe.feature.promotion.domain.evaluator;

import com.flarecafe.feature.promotion.domain.PromotionConditionEvaluator;
import com.flarecafe.feature.promotion.domain.model.ConditionType;
import com.flarecafe.feature.promotion.domain.model.PromotionCondition;

public class CategoryEvaluator implements PromotionConditionEvaluator {

  private final ConditionType conditionType = ConditionType.CATEGORY;
  private final String category; // TODO: category Enum으로 변경 필요
  
  public CategoryEvaluator(String category) {
    this.category = category;
  }

  @Override
  public boolean evaluate(PromotionCondition promotionCondition) {
    return promotionCondition.includesCategory(category);
  }
  
}
