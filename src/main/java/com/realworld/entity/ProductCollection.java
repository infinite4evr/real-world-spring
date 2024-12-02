package com.realworld.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "collection")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCollection {

  @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
  List<Product> products;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;

  @Column(unique = true)
  private String handle;

  private String metaData;
}
