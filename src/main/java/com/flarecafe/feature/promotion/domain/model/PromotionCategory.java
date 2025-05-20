package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
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

  // todo : category Enum으로 변경
//  @Enumerated(EnumType.STRING)
  private String category;

  public PromotionCategory(PromotionCondition promotionCondition, String category) {
    this.promotionCondition = promotionCondition;
    this.category = category;
  }
  
}
