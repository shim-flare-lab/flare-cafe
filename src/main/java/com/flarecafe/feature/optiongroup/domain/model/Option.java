package com.flarecafe.feature.optiongroup.domain.model;

import jakarta.persistence.*;

@Entity
public class Option {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private int price; // TODO: Money객체로 수정할것

  @ManyToOne
  @JoinColumn(name = "option_group_id")
  private OptionGroup optionGroup;
}
