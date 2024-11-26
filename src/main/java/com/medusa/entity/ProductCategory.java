package com.medusa.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    public ProductCategory(String name, String description, String handle, String mpath, boolean isActive, boolean isInternal, int rank, int parentCategoryId, String metaData) {
        this.name = name;
        this.description = description;
        this.handle = handle;
        this.mpath = mpath;
        this.isActive = isActive;
        this.isInternal = isInternal;
        this.rank = rank;
        this.parentCategoryId = parentCategoryId;
        this.metaData = metaData;
    }

    public  ProductCategory(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @Column(columnDefinition = "TEXT")
    private  String description;


    @Column(columnDefinition = "TEXT")
    private String handle;


    @Column(columnDefinition = "TEXT")
    private String mpath;

    private  boolean isActive;


    private boolean isInternal;


    private int rank;

    @Nullable
    private int parentCategoryId;


    @Column(columnDefinition = "TEXT")
    private String metaData;

    public int getId() {
        return id;
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

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isInternal() {
        return isInternal;
    }

    public void setInternal(boolean internal) {
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
