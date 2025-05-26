package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.menu.domain.model.Menu;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@Table(name = "promotion_menu")
@DynamicUpdate
@NoArgsConstructor
public class PromotionMenu extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "promotion_menu_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "promotion_condition_id")
  private PromotionCondition promotionCondition;
  
  @ManyToOne
  @JoinColumn(name = "menu_id")
  private Menu menu;

  public PromotionMenu(PromotionCondition promotionCondition, Menu menu) {
    this.promotionCondition = promotionCondition;
    this.menu = menu;
  }
  
}
