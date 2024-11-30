package com.medusa.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SalesChannelDTO {
  private int id;

  @NotBlank
  @Size(min = 2, max = 70)
  private String name;

  private String description;

  private boolean isDisabled;
}
