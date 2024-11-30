package com.medusa.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "product_category")
public class ProductCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(columnDefinition = "TEXT")
  private String handle;

  @Column(columnDefinition = "TEXT")
  private String mpath;

  private boolean isActive;
  private boolean isInternal;
  private int rank;
  @Nullable private int parentCategoryId;

  @Column(columnDefinition = "TEXT")
  private String metaData;
}
