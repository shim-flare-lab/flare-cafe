package com.flarecafe.feature.promotion.domain.evaluator;

import com.flarecafe.feature.promotion.domain.support.ConditionType;

public interface EvaluateSupportable {

  boolean supports(ConditionType conditionType);
  
}
