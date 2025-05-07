package com.flarecafe.feature.generic;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

  @Column(nullable = false, updatable = false, unique = true)
  private String uniqueId = UUID.randomUUID().toString();
  
  @Column(nullable = false, updatable = false)
  @CreatedDate
  private LocalDateTime createdAt;

  @Column(nullable = false, updatable = false)
  private String createdUserId;
  
  @Column(nullable = false)
  @LastModifiedDate
  private LocalDateTime modifiedAt;

  @Column(nullable = false)
  private String modifiedUserId;
  
  protected void createdBy(String userId) {
    this.createdUserId = userId;
    this.modifiedUserId = userId;
  }
  
  protected void updateBy(String userId) {
    this.modifiedUserId = userId;
  }

  @Override
  public String toString() {
    return "BaseEntity{" +
            "uniqueId='" + uniqueId + '\'' +
            ", createdAt=" + createdAt +
            ", createdUserId='" + createdUserId + '\'' +
            ", modifiedAt=" + modifiedAt +
            ", modifiedUserId='" + modifiedUserId + '\'' +
            '}';
  }
  
}