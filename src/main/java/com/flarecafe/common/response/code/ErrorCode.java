package com.flarecafe.common.response.code;

import lombok.Getter;

@Getter
public enum ErrorCode {
  INVALID_INPUT_VALUE("0001", "Invalid Input Value"),

  // Business Errors
  INVALID_MENU_NAME("0002", "Invalid menu name"),
  ;

  private static final String PREFIX = "FLARE-CAFE-ERROR-%s";
  private final String code;
  private final String message;

  ErrorCode(String code, String message) {
    this.code = String.format(PREFIX, code);
    this.message = message;
  }
}