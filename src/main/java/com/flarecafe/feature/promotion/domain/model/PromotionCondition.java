package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.promotion.domain.support.ConditionType;
import com.flarecafe.feature.promotion.domain.support.PromotionCategories;
import com.flarecafe.feature.promotion.domain.support.PromotionMenus;
import jakarta.persistence.*;
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
  private PromotionCategories promotionCategories;
  
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
  
}
