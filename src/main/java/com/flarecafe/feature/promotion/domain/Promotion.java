package com.flarecafe.feature.promotion.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "promotion")
@NoArgsConstructor(access = PROTECTED)
public class Promotion {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public Promotion(Long id) {
    this.id = id;
  }
  
  public static Promotion of() {
    return new Promotion();
  }
  
  public void update() {
    // amount
    // apply menu
    // condition
  }
  
}
