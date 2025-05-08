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

  @Column(nullable = false, updatable = false, name = "unique_id", unique = true)
  private String uniqueId = UUID.randomUUID().toString();
  
  @Column(nullable = false, updatable = false, name = "created_date_time")
  @CreatedDate
  private LocalDateTime createdAt;

  @Column(nullable = false, updatable = false, name = "created_user_id")
  protected String createdUserId;
  
  @Column(nullable = false , name ="modified_date_time")
  @LastModifiedDate
  private LocalDateTime modifiedAt;

  @Column(nullable = false, name = "modified_user_id")
  protected String modifiedUserId;
  
  @Override
  public String toString() {
    return "BaseEntity{" +
      "createdAt=" + createdAt +
      ", createdUserId='" + createdUserId + '\'' +
      ", modifiedAt=" + modifiedAt +
      ", modifiedUserId='" + modifiedUserId + '\'' +
      '}';
  }
  
}