package com.medusa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_variant")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductVariant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "sku")
  private String sku;

  @Column(name = "barcode")
  private String barcode;

  @Column(name = "ean")
  private String ean;

  @Column(name = "upc")
  private String upc;

  @Column(name = "allow_backorder")
  private boolean allowBackOrder;

  @Column(name = "manage_inventory")
  private boolean manageInventory;

  @Column(name = "hs_code")
  private String hsCode;

  @Column(name = "origin_country")
  private String originCountry;

  @Column(name = "mid_code")
  private String midCode;

  @Column(name = "material")
  private String material;

  @Column(name = "weight")
  private String weight;

  @Column(name = "length")
  private String length;

  @Column(name = "height")
  private String height;

  @Column(name = "width")
  private String width;

  @Column(columnDefinition = "TEXT")
  private Object metaData;

  @Column(name = "variant_rank")
  private Integer variantRank;

  @ManyToOne(targetEntity = Product.class)
  @JoinColumn(name = "product_id")
  private Product product;
}
