package com.flarecafe.feature.generic;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TimeInterval {
  
  private static final LocalDateTime FAR_PAST = LocalDateTime.of(1970, 1, 1, 0, 0);
  private static final LocalDateTime FAR_FUTURE = LocalDateTime.of(9999, 12, 31, 23, 59, 59);
  public static final TimeInterval UN_LIMITED = TimeInterval.of(FAR_PAST, FAR_FUTURE); 
  
  @Column(nullable = false)
  private LocalDateTime startAt;
  
  @Column(nullable = false)
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

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof TimeInterval that)) return false;
    return Objects.equals(startAt, that.startAt) && Objects.equals(endAt, that.endAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startAt, endAt);
  }
  
}
