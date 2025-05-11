package com.flarecafe.feature.menu.domain.model;

import com.flarecafe.feature.menu.domain.model.enums.MenuStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  private String name;

  private int price; // TODO: Money객체로 수정할것

  @Column(length = 1000)
  private String ingredients;

  @OneToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  @Enumerated(EnumType.STRING)
  private MenuStatus status;

  @OneToMany(mappedBy = "menu")
  private List<MenuOptionGroup> optionGroups = new ArrayList<>();

  private LocalDateTime createdDate; // TODO: BaseEntity가 생기면 수정

  private static final int NEW_MENU_PERIOD_DAYS = 28;

  public boolean isNewMenu() {
    return ChronoUnit.DAYS.between(this.createdDate, LocalDate.now()) <= NEW_MENU_PERIOD_DAYS;
  }

  public boolean isPromotionActive() {
    return true; // promotion도메인이 머지되면 추가
  }
}
