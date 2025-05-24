package com.flarecafe.feature.menu.domain.model.support;

public enum Category {
  COFFEE("커피"),
  TEA("차"),
  ADE("에이드"),
  DESSERT("디저트"),
  ;

  private final String label;

  Category(String label) {
    this.label = label;
  }

  public String label() {
    return this.label;
  }
}
