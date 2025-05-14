package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.generic.Status;
import com.flarecafe.feature.generic.TimeInterval;
import com.flarecafe.feature.promotion.domain.PromotionConditionEvaluator;
import com.flarecafe.feature.promotion.domain.PromotionConditionFactory;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "promotion")
@DynamicUpdate
@NoArgsConstructor
public class Promotion extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "promotion_id")
  private Long id;
  
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private DiscountType discountType;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false, length = 1000)
  private String description;

  @Column(nullable = false)
  private int priority;
  
  @Embedded
  private Money discountAmount;
  
  private Integer discountPercentage;
  
  @Embedded
  private TimeInterval promotionPeriod;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion", orphanRemoval = true)
  private List<PromotionCondition> promotionConditions;
  
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status = Status.ACTIVE;

  public Promotion(Long id) {
    this.id = id;
  }
  
  public static Promotion of() {
    return new Promotion();
  }
  
  public void update(String name, String description, int priority, DiscountType discountType, Money discountAmount, Integer discountPercentage, TimeInterval promotionPeriod) {
    this.name = name;
    this.description = description;
    this.priority = priority;
    this.discountType = discountType;
    this.discountAmount = discountAmount;
    this.discountPercentage = discountPercentage;
    this.promotionPeriod = promotionPeriod;
  }
  
  public void delete(String modifiedUserId) {
    this.status = Status.DELETED;
    this.updateBy(modifiedUserId);
  }
  
  
  // todo : implementation, menu로 변경필요
  public Money calculateAmount(String menu, PromotionConditionFactory promotionConditionFactory) {

    for (PromotionCondition promotionCondition : promotionConditions) {
      PromotionConditionEvaluator evaluator = promotionConditionFactory.resolve(menu, promotionCondition);
      if (evaluator.evaluate(promotionCondition)) {
        // TODO : 할인 대상 찾았고, 할인 적용필요.
      }
    }
    
    return Money.ZERO;
  }
  
  @Override
  public String toString() {
    return "Promotion{" +
            "id=" + id +
            ", status=" + status +
            ", " + super.toString() +
            '}';
  }

  public boolean isInRange(LocalDateTime localDateTime) {
    
    return promotionPeriod.isInRange(localDateTime);
  
  }
}
