package com.realworld.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "items")
public class InventoryItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String sku;

  @Column(name = "hs_code")
  private String hsCode;

  private double weight;

  private double length;

  private double height;

  private double width;

  @Column(name = "origin_country", nullable = false)
  private String originCountry;

  @Column(name = "mid_code")
  private String midCode;

  @Column(nullable = false)
  private String material;

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(name = "requires_shipping", nullable = false)
  private boolean requiresShipping;

  @Column(nullable = true)
  private String thumbnail;

  @Column(name = "meta_Data")
  private String metadata;
}
