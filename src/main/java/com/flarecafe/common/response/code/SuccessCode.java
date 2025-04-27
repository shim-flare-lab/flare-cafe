package com.flarecafe.common.response.code;

import lombok.Getter;

@Getter
public enum SuccessCode {
  OK("0001", "Request Successful"),
  ;

  private static final String PREFIX = "FLARE-CAFE-SUCCESS-%s";
  private final String code;
  private final String message;

  SuccessCode(String message, String code) {
    this.message = String.format(PREFIX, message);
    this.code = code;
  }
}