package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.generic.TimeInterval;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import jakarta.persistence.*;
import lombok.Builder;
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
  private final List<PromotionCondition> promotionConditions = new ArrayList<>();

  @Builder
  public Promotion(DiscountType discountType, String name, String description, Money discountAmount, Integer discountPercentage, TimeInterval promotionPeriod, String createdUserId) {
    this.discountType = discountType;
    this.name = name;
    this.description = description;
    this.discountAmount = discountAmount;
    this.discountPercentage = discountPercentage;
    this.promotionPeriod = promotionPeriod;
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
  
  public void addPromotionCondition(PromotionCondition promotionCondition) {
    this.getPromotionConditions().add(promotionCondition);
    promotionCondition.updatePromotion(this);
  }
  
  public void delete(String modifiedUserId) {
    this.deleteBy(modifiedUserId);
  }

  public boolean isInRange(LocalDateTime localDateTime) {
    return promotionPeriod.isInRange(localDateTime);
  }
  
  public static Promotion fixture() {

    Promotion promotion = Promotion.builder()
      .discountType(DiscountType.AMOUNT)
      .name("여름한정 이벤트 ! ")
      .description("안녕하세요 여름한정 이벤트가 열립니다.")
      .discountAmount(Money.of(10000))
      .promotionPeriod(TimeInterval.UN_LIMITED)
      .createdUserId("bright-flare")
      .build();
    
    promotion.addPromotionCondition(PromotionCondition.fixture());

    return promotion;
    
  }
  
}
