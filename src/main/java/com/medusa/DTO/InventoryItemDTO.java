package com.medusa.DTO;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItemDTO {
  private Long id;

  private String sku;

  private String hsCode;

  private double weight;

  private double length;

  private double height;

  private double width;

  private String originCountry;

  private String midCode;

  private String material;

  private String title;

  private String description;

  private boolean requiresShipping;

  private String thumbnail;

  private String metadata;
}
