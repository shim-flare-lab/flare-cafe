package com.flarecafe.feature.generic;

public record IdResponse(Long id) {
  
  public static IdResponse of(Long id) {
    return new IdResponse(id);
  }
  
}
