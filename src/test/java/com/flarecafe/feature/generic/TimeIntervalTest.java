package com.flarecafe.feature.generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 학습 테스트 코드
 */
@DisplayName("Learning Test for TimeInterval")
class TimeIntervalTest {

  @Test
  void isInRange() {

    // given
    LocalDateTime start = LocalDateTime.of(2025, Month.MAY, 1, 0, 0);
    LocalDateTime end = LocalDateTime.of(2025, Month.MAY, 31, 0, 0);
    LocalDateTime startEqDate = LocalDateTime.of(2025, Month.MAY, 1, 0, 0);
    LocalDateTime startAfterDate = LocalDateTime.of(2025, Month.MAY, 10, 0, 0);
    
    TimeInterval timeInterval = TimeInterval.of(start, end);

    // when
    boolean activeAt = timeInterval.isInRange(startEqDate);
    boolean activeAt2 = timeInterval.isInRange(startAfterDate);

    // then
    assertTrue(activeAt);
    assertTrue(activeAt2);
  }
  
}