package com.flarecafe.common.response;

import com.flarecafe.common.response.code.success.SuccessCode;
import lombok.Getter;

@Getter
public class SuccessResponse<T> {

  private final String code;
  private final String message;
  private final T data;

  public SuccessResponse(SuccessCode successCode, T data) {
    this.code = successCode.getCode();
    this.message = successCode.getMessage();
    this.data = data;
  }

  public SuccessResponse(SuccessCode successCode) {
    this.code = successCode.getCode();
    this.message = successCode.getMessage();
    this.data = null;
  }

  public static <T> SuccessResponse<T> of(SuccessCode successCode, T data) {
    return new SuccessResponse<>(successCode, data);
  }

  public static <T> SuccessResponse<T> emptyData() {
    return new SuccessResponse<>(SuccessCode.OK);
  }

  public static <T> SuccessResponse<T> ok(T data) {
    return new SuccessResponse<>(SuccessCode.OK, data);
  }
}