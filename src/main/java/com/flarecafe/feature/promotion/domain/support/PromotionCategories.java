package com.flarecafe.feature.promotion.domain.support;

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
  
  // todo menu domain으로 변경 필요
  public boolean includes(String category) {
    return promotionCategories.stream()
      .filter(PromotionCategory::isActive)
      .anyMatch(promotionCategory -> promotionCategory.equals(category));
  }
  
}
