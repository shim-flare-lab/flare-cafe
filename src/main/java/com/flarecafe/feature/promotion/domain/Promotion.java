package com.flarecafe.feature.promotion.domain;

import com.flarecafe.feature.generic.BaseEntity;
import com.flarecafe.feature.generic.Status;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "promotion")
@NoArgsConstructor(access = PROTECTED)
@DynamicUpdate
public class Promotion extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false, length = 10)
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
    this.modifiedUserId = modifiedUserId;
  }
  
  @Override
  public String toString() {
    return "Promotion{" +
            "id=" + id +
            ", status=" + status +
            ", uniqueId=" + getUniqueId() +
            ", createdAt='" + getCreatedAt() + '\'' +
            ", createdUserId='" + createdUserId + '\'' +
            ", modifiedAt='" + getModifiedAt() + '\'' +
            ", modifiedUserId='" + modifiedUserId + '\'' +
            '}';
  }
}
