package com.flarecafe.feature.optiongroup.domain.model;

import com.flarecafe.feature.generic.Money;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "option_item")
public class OptionItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Embedded
  private Money price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "option_group_id")
  private OptionGroup optionGroup;

  public BigDecimal getPrice() {
    return this.price.getAmount();
  }
}
