package com.flarecafe.feature.generic;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TimeInterval {
  
  private LocalDateTime startAt;
  
  private LocalDateTime endAt;

  public TimeInterval(LocalDateTime startAt, LocalDateTime endAt) {
    this.startAt = startAt;
    this.endAt = endAt;
  }

  public static TimeInterval of(LocalDateTime startAt, LocalDateTime endAt) {
    return new TimeInterval(startAt, endAt);
  }

  public boolean isInRange(LocalDateTime dateTime) {
    return isStartAtEqOrBefore(dateTime) && isEndAtEqOrAfter(dateTime);
  }
  
  private boolean isStartAtEqOrBefore(LocalDateTime dateTime) {
    return this.startAt.isEqual(dateTime) || this.startAt.isBefore(dateTime); 
  }
  
  private boolean isEndAtEqOrAfter(LocalDateTime dateTime) {
    return this.endAt.isEqual(dateTime) || this.endAt.isAfter(dateTime); 
  }

}
