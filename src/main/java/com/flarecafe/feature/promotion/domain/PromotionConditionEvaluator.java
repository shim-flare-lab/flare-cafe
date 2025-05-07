package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.promotion.domain.evaluator.EvaluateSupportable;
import com.flarecafe.feature.promotion.domain.model.Promotion;

import java.awt.*;

public interface PromotionConditionEvaluator extends EvaluateSupportable {
  
  boolean evaluate(Promotion promotion, String menu);
  
}
