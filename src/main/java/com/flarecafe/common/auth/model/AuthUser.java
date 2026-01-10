package com.flarecafe.common.auth.model;

public record AuthUser(Long userId, String userLoginId, String username) {
  
  public static AuthUser fixture() {
    return new AuthUser(1L, "bright-brother", "luminous_bright_human");
  }
}
