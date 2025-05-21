package com.flarecafe.feature.menu.domain.model.support;

public enum MenuStatus {
  SELLABLE( "품절"),
  SOLD_OUT( "판매 가능");

  private final String label;

  MenuStatus(String label) {
    this.label = label;
  }

  public String label() {
    return this.label;
  }
}
