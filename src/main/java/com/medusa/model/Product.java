package com.medusa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public String title;
  public String subtitle;

  public Boolean isGiftcard;
  public Boolean discountable;
  public String thumbnail;
  public String handle;
  public String status;
  public String typeId;
  public String collectionId;
  public Double weight;
  public Double length;
  public Double height;
  public Double width;
  public String hsCode;
  public String midCode;
  public String originCountry;
  public String material;
  public String externalId;

  // @ElementCollection
  // public Map<String, Object> metadata;

  // @ElementCollection
  // public Map<String, Object> additionalData;

  // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  // public List<Image> images;

  // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  // public List<Category> categories;

  // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  // public List<Tag> tags;

  // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  // public List<Variant> variants;

  // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  // public List<SalesChannel> salesChannels;

  // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  // public List<Option> options;

  // // Getters and Setters
}
