package com.flarecafe.feature.menu.domain.model;

import com.flarecafe.feature.generic.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "ingredient")
@NoArgsConstructor
public class Ingredient extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
  private List<RecipeDetail> recipeDetails = new ArrayList<>();

  @Builder
  public Ingredient(String name, String createdUserId) {
    this.name = name;
    this.createdBy(createdUserId);
  }

  public void update(String name, String userId) {
    this.name = name;
    this.updateBy(userId);
  }

  public void delete(String modifiedUserId) {
    this.updateBy(modifiedUserId);
  }
}
