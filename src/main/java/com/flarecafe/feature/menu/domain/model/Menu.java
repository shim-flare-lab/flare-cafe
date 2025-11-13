package com.flarecafe.feature.menu.domain.model;

import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.menu.domain.model.support.Category;
import com.flarecafe.feature.menu.domain.model.support.MenuStatus;
import com.flarecafe.feature.optiongroup.domain.model.OptionItem;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
public class Menu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private Category category;

  private String name;

  @Embedded
  private Money price;

  @Column(length = 1000)
  private String ingredients;

  @OneToOne
  @JoinColumn(name = "recipe_id")
  private Recipe recipe;

  private String imageUrl;

  @Enumerated(EnumType.STRING)
  private MenuStatus status;

  @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
  private List<MenuOptionGroup> optionGroups = new ArrayList<>();

  private LocalDateTime createdDate; // TODO: BaseEntity가 생기면 수정

  private static final int NEW_MENU_PERIOD_DAYS = 28;

  public boolean isNewMenu() {
    return ChronoUnit.DAYS.between(this.createdDate, LocalDate.now()) <= NEW_MENU_PERIOD_DAYS;
  }

  public boolean isPromotionActive() {
    return true; // promotion도메인이 머지되면 추가
  }

  public BigDecimal calculateTotalPrice(List<OptionItem> optionItems) {
    BigDecimal totalOptionPrice = optionItems.stream()
      .map(OptionItem::getPrice)
      .reduce(BigDecimal.ZERO, BigDecimal::add);

    return this.price.getAmount().add(totalOptionPrice);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Menu menu)) return false;
    return Objects.equals(id, menu.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
  
  public static Menu fixture() {
    Menu menu = new Menu();
    menu.category = Category.COFFEE;
    menu.name = "커피";
    menu.price = Money.of(10000);
    menu.ingredients = "커피, 우유, 초콜릿";
    menu.imageUrl = "https://cdn.pixabay.com/photo/2017/08/12/18/58/coffee-2635031_1280.jpg";
    menu.status = MenuStatus.SELLABLE;
    menu.createdDate = LocalDateTime.now();
    return menu;
  }
  
}
