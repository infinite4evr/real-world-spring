package com.medusa.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String subtitle;
  private String description;
  private Boolean isGiftCard;
  private Boolean discountable;
  private String thumbnail;
  private String handle;
  private String status;
  private String typeId;
  private String collectionId;
  private String sku;
  private String ean;
  private String upc;
  private String barcode;
  private String hsCode;
  private String midCode;
  private Boolean allowBackorder;
  private Boolean manageInventory;
  private Integer variantRank;
  private Double weight;
  private Double length;
  private Double height;
  private Double width;
  private String originCountry;
  private String material;
  private String externalId;
}
