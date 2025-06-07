package com.flarecafe.feature.promotion.domain.evaluator;

import com.flarecafe.feature.menu.domain.model.Menu;
import com.flarecafe.feature.menu.domain.model.support.Category;

public record EvaluationContext(Category category, Menu menu) {

  public static EvaluationContext of(Menu menu) {
    return new EvaluationContext(menu.getCategory(), menu);
  }

}
