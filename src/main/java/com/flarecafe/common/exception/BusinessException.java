package com.flarecafe.common.exception;

import com.flarecafe.common.response.code.error.BusinessErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final BusinessErrorCode errorCode;

  public BusinessException(BusinessErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
  
}