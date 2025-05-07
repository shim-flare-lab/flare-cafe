package com.flarecafe.feature.promotion.domain.evaluator;

import com.flarecafe.feature.promotion.domain.PromotionConditionEvaluator;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.ConditionType;

public class MenuEvaluator implements PromotionConditionEvaluator {

  private final ConditionType conditionType = ConditionType.MENU;
  
  @Override
  public boolean evaluate(Promotion promotion, String menu){
    return false;
  }

  @Override
  public boolean supports(ConditionType conditionType) {
    return false;
  }

}
