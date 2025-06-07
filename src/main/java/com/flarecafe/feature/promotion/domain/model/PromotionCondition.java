package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.menu.domain.model.Menu;
import com.flarecafe.feature.menu.domain.model.support.Category;
import com.flarecafe.feature.promotion.domain.evaluator.EvaluationContext;
import com.flarecafe.feature.promotion.domain.support.ConditionType;
import com.flarecafe.feature.promotion.domain.support.PromotionCategories;
import com.flarecafe.feature.promotion.domain.support.PromotionMenus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "promotion_condition")
@DynamicUpdate
@NoArgsConstructor
public class PromotionCondition extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "promotion_condition_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "promotion_id")
  private Promotion promotion;
  
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private ConditionType conditionType;

  @Embedded
  private PromotionMenus promotionMenus;

  @Embedded
  private final PromotionCategories promotionCategories = new PromotionCategories();

  @Builder
  public PromotionCondition(Promotion promotion, ConditionType conditionType, PromotionMenus promotionMenus) {
    this.promotion = promotion;
    this.conditionType = conditionType;
    this.promotionMenus = promotionMenus;
  }

  public boolean evaluate(Menu menu) {
    return conditionType.evaluate(this, EvaluationContext.of(menu));
  }

  public boolean includesMenu(Menu menu) {
    return promotionMenus.includes(menu);
  }

  public boolean includesCategory(Category category) {
    return promotionCategories.includes(category);
  }

  public boolean isInRange(LocalDateTime localDateTime) {
    return promotion.isInRange(localDateTime);
  }

  public void updatePromotion(Promotion promotion) {
    this.promotion = promotion;
  }

  public static PromotionCondition fixture() {

    PromotionCondition promotionCondition = PromotionCondition.builder()
            .conditionType(ConditionType.CATEGORY)
            .build();

    PromotionCategory coffee = new PromotionCategory(promotionCondition, Category.COFFEE);
    promotionCondition.promotionCategories.add(coffee);

    return promotionCondition; 
  }
  
}
