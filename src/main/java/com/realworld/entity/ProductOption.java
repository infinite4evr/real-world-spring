package com.realworld.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "product_option")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOption {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title")
  private String title;

  @OneToMany(targetEntity = ProductOptionValue.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "option_id")
  @Singular
  private List<ProductOptionValue> productOptionValues;

  @Column(columnDefinition = "TEXT")
  private Object metaData;
}
