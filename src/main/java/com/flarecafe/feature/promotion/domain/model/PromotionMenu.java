package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

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
  
  // todo : menu 연관관계 설정 필요
  private String menu;

}
