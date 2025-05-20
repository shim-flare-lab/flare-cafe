package com.flarecafe.feature.promotion.domain.evaluator;

public record EvaluationContext(String category, String menu) {

  public static EvaluationContext of(String category, String menu) {
    return new EvaluationContext(category, menu);
  }

}
