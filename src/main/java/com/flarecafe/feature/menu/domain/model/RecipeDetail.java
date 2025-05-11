package com.flarecafe.feature.menu.domain.model;

import jakarta.persistence.*;

@Entity
public class RecipeDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer sortOrder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ingredient_id")
  private Ingredient ingredient;

  private String description;
}
