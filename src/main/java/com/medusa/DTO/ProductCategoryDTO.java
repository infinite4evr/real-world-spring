package com.medusa.DTO;


import com.medusa.annotations.ExistsInDatabase.ExistsInDatabase;
import com.medusa.entity.ProductCategory;
import jakarta.validation.constraints.*;

public class ProductCategoryDTO {
    private int id;

    @NotBlank
    @Size(min = 2, max = 70)
    private String name;

    @Size(max = 200)
    private  String description;

    private String handle;

    private String mpath;

    //@Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private  boolean isActive;

    //@Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")

    private boolean isInternal;

    @Digits(integer = 5, fraction = 0)
    @PositiveOrZero
    private int rank;



    @ExistsInDatabase(entity = ProductCategory.class, column = "id", message = "Invalid Parent Id", allowZeroInt = true)
    private int parentCategoryId;


    private String metaData;

    public ProductCategoryDTO() {
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getMpath() {
        return mpath;
    }

    public void setMpath(String mpath) {
        this.mpath = mpath;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public boolean isInternal() {
        return isInternal;
    }

    public void setIsInternal(boolean internal) {
        isInternal = internal;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }
}
