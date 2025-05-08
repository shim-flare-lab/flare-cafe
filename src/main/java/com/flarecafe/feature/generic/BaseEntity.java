package com.flarecafe.feature.generic;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

  @Column(nullable = false, updatable = false, name = "created_date_time", columnDefinition = "생성 일시")
  @CreatedDate
  private LocalDateTime createdAt;

  @Column(nullable = false, updatable = false, name = "created_user_id", columnDefinition = "생성자 id")
  protected String createdBy;
  
  @Column(nullable = false , name ="modified_date_time", columnDefinition = "최종 수정 일시")
  @LastModifiedDate
  private LocalDateTime modifiedAt;

  @Column(nullable = false, name = "modified_user_id", columnDefinition = "최종 수정자 id")
  protected String modifiedBy;
  
}
