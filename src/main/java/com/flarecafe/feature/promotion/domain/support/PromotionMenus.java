package com.flarecafe.feature.promotion.domain.support;

import com.flarecafe.feature.menu.domain.model.Menu;
import com.flarecafe.feature.promotion.domain.model.PromotionMenu;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class PromotionMenus {

  @OneToMany(mappedBy = "promotionCondition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private final List<PromotionMenu> promotionMenus;

  protected PromotionMenus() {
    this.promotionMenus = new ArrayList<>();
  }

  private PromotionMenus(List<PromotionMenu> promotionMenus) {
    this.promotionMenus = promotionMenus;
  }

  public boolean includes(Menu menu) {
    return promotionMenus.stream()
      .filter(PromotionMenu::isNotDeleted)
      .anyMatch(promotionMenu -> promotionMenu.getMenu().equals(menu));
  }
  
}
