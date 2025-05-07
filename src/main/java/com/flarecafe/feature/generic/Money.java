package com.flarecafe.feature.generic;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor
public class Money {
  
  public static final Money ZERO = Money.of(0);

  private BigDecimal amount;
  
  Money(BigDecimal amount) {
    this.amount = amount;
  }

  public static Money of(long amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public static Money of(double amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public Money plus(Money amount) {
    return new Money(this.amount.add(amount.amount));
  }

  public Money minus(Money amount) {
    return new Money(this.amount.subtract(amount.amount));
  }

  public Money applyPercentage(int percent) {
    return new Money(this.amount
      .multiply(BigDecimal.valueOf(percent))
      .divide(BigDecimal.valueOf(100)));
  }

  public Money divide(double divisor) {
    return new Money(amount.divide(BigDecimal.valueOf(divisor)));
  }

  public boolean isLessThan(Money other) {
    return amount.compareTo(other.amount) < 0;
  }

  public boolean isGreaterThanOrEqual(Money other) {
    return amount.compareTo(other.amount) >= 0;
  }

  public Long longValue() {
    return amount.longValue();
  }

  public Double doubleValue() {
    return amount.doubleValue();
  }

  public String toString() {
    return amount.toString();
  }
  

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    Money money = (Money) other;
    return Objects.equals(amount.doubleValue(), money.amount.doubleValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount.doubleValue());
  }
}
