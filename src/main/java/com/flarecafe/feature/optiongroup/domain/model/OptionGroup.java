package com.flarecafe.feature.optiongroup.domain.model;

import com.flarecafe.feature.optiongroup.domain.model.enums.OptionGroupType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class OptionGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private OptionGroupType type;

  @OneToMany
  @JoinColumn(name = "option_id")
  private List<Option> options;
}
