package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.promotion.domain.model.PromotionCondition;

public interface PromotionConditionEvaluator {
  boolean evaluate(PromotionCondition promotionCondition);
  
}
