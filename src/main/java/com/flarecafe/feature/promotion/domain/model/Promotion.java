package com.flarecafe.feature.promotion.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.generic.Status;
import com.flarecafe.feature.promotion.domain.support.PromotionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

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
  private PromotionType promotionType;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false, length = 1000)
  private String description;

  @Column(nullable = false)
  private int priority;
  
  @Embedded
  private Money amount;
  
  private Integer percentage;
  
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
  
  public void update(String name, String description, int priority, PromotionType promotionType, Money amount, Integer percentage) {
    this.name = name;
    this.description = description;
    this.priority = priority;
    this.promotionType = promotionType;
    this.amount = amount;
    this.percentage = percentage;
  }
  
  public void delete(String modifiedUserId) {
    this.status = Status.DELETED;
    this.updateBy(modifiedUserId);
  }
  
  
  // toto : implementation
  public Money calculateAmount() {
    promotionConditions.stream();
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
}
