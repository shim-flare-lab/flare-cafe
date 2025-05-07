package com.flarecafe.feature.promotion.domain.evaluator;

import com.flarecafe.feature.promotion.domain.*;
import com.flarecafe.feature.promotion.domain.model.ConditionType;
import com.flarecafe.feature.promotion.domain.model.PromotionCondition;

public class MenuEvaluator implements PromotionConditionEvaluator {

  private final ConditionType conditionType = ConditionType.MENU;
  private final String menu; // TODO: Menu domain으로 변경 필요

  public MenuEvaluator(String menu) {
    this.menu = menu;
  }

  @Override
  public boolean evaluate(PromotionCondition promotionCondition) {
    return promotionCondition.includesMenu(menu);
  }
  
}
