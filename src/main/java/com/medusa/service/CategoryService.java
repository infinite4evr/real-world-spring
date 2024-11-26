package com.medusa.service;

import com.medusa.DTO.ProductCategoryDTO;
import com.medusa.entity.ProductCategory;
import com.medusa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    final private CategoryRepository repository;


    @Autowired
    public CategoryService(CategoryRepository repository){
        System.out.println("Setting category service" + repository);
        this.repository = repository;
    }

    public List<ProductCategory> getCategoryList(){
        return repository.findAll();
    }

    public ProductCategory createCategory(ProductCategoryDTO productCategoryDTO){
        var category = new ProductCategory();
        category.setName(productCategoryDTO.getName());
        category.setDescription(productCategoryDTO.getDescription());
        category.setHandle(productCategoryDTO.getHandle());
        category.setInternal(productCategoryDTO.isInternal());
        category.setActive(productCategoryDTO.isActive());
        category.setRank(productCategoryDTO.getRank());
        category.setParentCategoryId(productCategoryDTO.getParentCategoryId());
        category.setMetaData(productCategoryDTO.getMetaData());

        return repository.save(category);
    }
}
