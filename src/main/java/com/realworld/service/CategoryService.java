package com.realworld.service;

import com.realworld.DTO.ProductCategoryDTO;
import com.realworld.entity.ProductCategory;
import com.realworld.exception.EntityNotFoundException;
import com.realworld.repository.CategoryRepository;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class CategoryService {

  private final CategoryRepository repository;

  @Autowired
  public CategoryService(CategoryRepository repository) {
    System.out.println("Setting category service" + repository);
    this.repository = repository;
  }

  public List<ProductCategory> getCategoryList() {
    return repository.findAll();
  }

  public ProductCategory getCategory(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("category", id));
  }

  public ProductCategory createCategory(ProductCategoryDTO productCategoryDTO) {

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

  public boolean ifExists(Long id) {
    return repository.existsById(id);
  }

  public boolean ifExistsByName(String name) {
    return repository.existsProductCategoriesByName(name);
  }

  public boolean ifExistsOrError(Long id) {
    if (repository.existsById(id)) {
      return true;
    }

    throw new EntityNotFoundException("Category", id);
  }

  public boolean deleteCategory(Long id) {
    repository.deleteById(id);
    return !repository.existsById(id);
  }

  public ProductCategory updateCategory(Long id, Map<String, Object> updates) {
    ProductCategory category =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Category not found", id));
    updates.forEach(
        (key, value) -> {
          Field field = ReflectionUtils.findField(ProductCategory.class, key);
          if (field != null) {
            field.setAccessible(true);
            ReflectionUtils.setField(field, category, value);
          }
        });

    return repository.save(category);
  }

  public List<ProductCategory> getCustomQueryList() {
    return repository.getAllCategory();
  }
}
