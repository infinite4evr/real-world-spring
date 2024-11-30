package com.medusa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_option_value")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductOptionValue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "value")
  private String value;

  @ManyToOne(targetEntity = ProductOption.class)
  @JoinColumn(name = "option_id")
  private ProductOption option;

  @Column(columnDefinition = "TEXT")
  private Object metaData;
}
