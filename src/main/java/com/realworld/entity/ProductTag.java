package com.realworld.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_tag")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductTag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "value")
  private String value;

  @Nullable private int parentCategoryId;

  @Column(columnDefinition = "TEXT")
  private Object metaData;
}
