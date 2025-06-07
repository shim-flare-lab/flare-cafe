package com.flarecafe.feature.promotion.domain.support;

import com.flarecafe.feature.menu.domain.model.support.Category;
import com.flarecafe.feature.promotion.domain.model.PromotionCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class PromotionCategories {

  @OneToMany(mappedBy = "promotionCondition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private final List<PromotionCategory> promotionCategories;

  public PromotionCategories() {
    this.promotionCategories = new ArrayList<>();
  }

  public PromotionCategories(List<PromotionCategory> promotionCategories) {
    this.promotionCategories = promotionCategories;
  }
  
  public void add(PromotionCategory promotionCategory) {
    promotionCategories.add(promotionCategory);
  }
  
  public boolean includes(Category category) {
    return promotionCategories.stream()
      .filter(PromotionCategory::isNotDeleted)
      .anyMatch(promotionCategory -> promotionCategory.getCategory() == category);
  }
  
}
