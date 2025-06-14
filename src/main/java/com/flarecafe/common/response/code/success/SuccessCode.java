package com.flarecafe.common.response.code.success;

import com.flarecafe.common.response.code.FlareCode;
import lombok.Getter;

@Getter
public enum SuccessCode implements FlareCode {
  
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