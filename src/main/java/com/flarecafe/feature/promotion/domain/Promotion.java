package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.generic.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "promotion")
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Promotion extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status = Status.ACTIVE;

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
    this.updateModifiedUser(modifiedUserId);
  }

  @Override
  public String toString() {
    return "Promotion{" +
            "id=" + id +
            ", status=" + status +
            ", " + super.toString() +
            '}';
  }
}
