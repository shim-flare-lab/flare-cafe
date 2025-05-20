package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
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
import java.util.ArrayList;

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

  // todo menu domain 으로 변경 필요
  public boolean includesMenu(String menu) {
    return promotionMenus.includes(menu);
  }
  
  // todo category enum으로 변경
  public boolean includesCategory(String category) {
    return promotionCategories.includes(category);
  }
  
  public boolean isInRange(LocalDateTime localDateTime) {
    return promotion.isInRange(localDateTime);
  }
  
  public boolean evaluate(String category, String menu) {
    return conditionType.evaluate(this, EvaluationContext.of(category, menu));
  }

  public void updatePromotion(Promotion promotion) {
    this.promotion = promotion;
  }

  public static PromotionCondition fixture() {

    PromotionCondition promotionCondition = PromotionCondition.builder()
            .conditionType(ConditionType.CATEGORY)
            .build();

    PromotionCategory latte = new PromotionCategory(promotionCondition, "latte");
    promotionCondition.promotionCategories.add(latte);

    return promotionCondition; 
  }
  
}
