package com.springsecurity.springsecuritytemplate.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private String createdAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;

    @LastModifiedDate
    @Column(insertable = false)
    private String updatedAt;
}
