package com.flarecafe.common.response;

import com.flarecafe.common.response.code.SuccessCode;
import lombok.Getter;

import java.util.List;

@Getter
public class SuccessListResponse<T> {

  private String code;
  private String message;
  private List<T> list;
  private int totalCount;
  private Integer pageSize;
  private Integer pageNumber;

  public SuccessListResponse(SuccessCode successCode, List<T> list) {
    this.code = successCode.getCode();
    this.message = successCode.getMessage();
    this.list = list;
    this.totalCount = list.size();
  }

  public static <T> SuccessListResponse<T> of(SuccessCode successCode, List<T> list) {
    return new SuccessListResponse<>(successCode, list);
  }
}