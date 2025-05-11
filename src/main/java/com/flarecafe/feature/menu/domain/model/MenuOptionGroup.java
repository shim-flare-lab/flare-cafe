package com.flarecafe.feature.menu.domain.model;

import com.flarecafe.feature.optiongroup.domain.model.OptionGroup;
import jakarta.persistence.*;

@Entity
public class MenuOptionGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "menu_id")
  private Menu menu;

  @ManyToOne
  @JoinColumn(name = "option_group_id")
  private OptionGroup optionGroup;
}
