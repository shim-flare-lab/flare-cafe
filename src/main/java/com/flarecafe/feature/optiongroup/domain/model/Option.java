package com.flarecafe.feature.optiongroup.domain.model;

import com.flarecafe.feature.generic.Money;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Option {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Embedded
  private Money price;

  @ManyToOne
  @JoinColumn(name = "option_group_id")
  private OptionGroup optionGroup;

  public BigDecimal getPrice() {
    return this.price.getAmount();
  }
}
