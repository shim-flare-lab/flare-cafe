package com.flarecafe.feature.menu.domain.model.enums;

public enum MenuStatus {
  SELLABLE,
  SOLD_OUT;

  public String label() {
    return switch (this) {
      case SELLABLE -> "판매 가능";
      case SOLD_OUT -> "품절";
    };
  }
}
