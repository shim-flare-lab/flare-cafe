package com.flarecafe.feature.menu.domain.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
  private List<RecipeDetail> recipeDetails = new ArrayList<>();
}
