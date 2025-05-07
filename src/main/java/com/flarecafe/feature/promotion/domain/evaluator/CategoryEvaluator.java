package com.flarecafe.feature.promotion.domain.evaluator;

import com.flarecafe.feature.promotion.domain.PromotionConditionEvaluator;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.model.PromotionCondition;
import com.flarecafe.feature.promotion.domain.support.ConditionType;
import com.flarecafe.feature.promotion.domain.support.PromotionCategories;

public class CategoryEvaluator implements PromotionConditionEvaluator {

  private final ConditionType conditionType = ConditionType.CATEGORY;
  private final PromotionCategories categories; // TODO: category Enum으로 변경 필요
  
  public CategoryEvaluator(PromotionCategories categories) {
    this.categories = categories;
  }

  @Override
  public boolean evaluate(Promotion promotion, String menu){
//    return categories.includes(category);
    return false;
  }

  @Override
  public boolean supports(ConditionType conditionType) {
    return this.conditionType == conditionType;
  }
  
}
