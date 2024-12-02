package com.realworld.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_types")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "value")
  private String value;

  @Column(columnDefinition = "TEXT")
  private String metaData;
}
