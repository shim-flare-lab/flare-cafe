package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.generic.Status;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "promotion")
@NoArgsConstructor(access = PROTECTED)
public class Promotion extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private Status status;

  public Promotion(Long id) {
    this.id = id;
  }
  
  public static Promotion of() {
    return new Promotion();
  }
  
  public void update(String modifiedUserId) {
    // amount
    // apply menu
    // condition
  }
  
  public void delete(String modifiedUserId) {
    this.status = Status.DELETED;
    this.modifiedBy = modifiedUserId;
  }
  
}
