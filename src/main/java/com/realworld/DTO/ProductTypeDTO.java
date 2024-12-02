package com.realworld.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductTypeDTO {
  private int id;

  @NotBlank
  @Size(min = 2, max = 70)
  private String value;

  private String metaData;
}
