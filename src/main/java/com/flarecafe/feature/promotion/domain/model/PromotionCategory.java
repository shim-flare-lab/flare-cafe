package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.menu.domain.model.support.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@Table(name = "promotion_category")
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PromotionCategory extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "promotion_condition_id")
  private PromotionCondition promotionCondition;

  @Enumerated(EnumType.STRING)
  private Category category;

  public PromotionCategory(PromotionCondition promotionCondition, Category category) {
    this.promotionCondition = promotionCondition;
    this.category = category;
  }
  
}
