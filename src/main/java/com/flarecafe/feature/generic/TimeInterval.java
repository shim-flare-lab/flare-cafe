package com.flarecafe.feature.generic;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TimeInterval {
  
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;

}
