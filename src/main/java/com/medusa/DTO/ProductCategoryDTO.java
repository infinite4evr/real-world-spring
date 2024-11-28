package com.medusa.DTO;


import com.medusa.annotations.ExistsInDatabase.ExistsInDatabase;
import com.medusa.entity.ProductCategory;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProductCategoryDTO {
    private int id;

    @NotBlank
    @Size(min = 2, max = 70)
    private String name;

    @Size(max = 200)
    private String description;

    private String handle;

    private String mpath;

    //@Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private boolean isActive;

    //@Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private boolean isInternal;

    @Digits(integer = 5, fraction = 0)
    @PositiveOrZero
    private int rank;


    @ExistsInDatabase(entity = ProductCategory.class, column = "id", message = "Invalid Parent Id", allowZeroInt = true)
    private int parentCategoryId;

    private String metaData;


}
