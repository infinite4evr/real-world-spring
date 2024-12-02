package com.realworld.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sales_channel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SalesChannel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  private boolean isDisabled;

  @Column(columnDefinition = "TEXT")
  private String metaData;
}
