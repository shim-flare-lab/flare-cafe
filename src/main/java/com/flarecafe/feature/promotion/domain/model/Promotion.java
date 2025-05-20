package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.generic.TimeInterval;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

  @Embedded
  private Money discountAmount;
  
  private Integer discountPercentage;
  
  @Embedded
  private TimeInterval promotionPeriod;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion", orphanRemoval = true)
  private List<PromotionCondition> promotionConditions;
  
  public Promotion(String createdUserId) {
    this.createdBy(createdUserId);
  }
  
  public static Promotion of() {
    return new Promotion();
  }
  
  public void update(String name, String description, DiscountType discountType, Money discountAmount, Integer discountPercentage, TimeInterval promotionPeriod, String userId) {
    this.name = name;
    this.description = description;
    this.discountType = discountType;
    this.discountAmount = discountAmount;
    this.discountPercentage = discountPercentage;
    this.promotionPeriod = promotionPeriod;
    this.updateBy(userId);
  }
  
  public void delete(String modifiedUserId) {
    this.deleteBy(modifiedUserId);
  }

  public boolean isInRange(LocalDateTime localDateTime) {
    return promotionPeriod.isInRange(localDateTime);
  }
  
}
