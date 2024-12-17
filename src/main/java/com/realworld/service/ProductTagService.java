package com.realworld.service;

import com.realworld.DTO.ProductTagDTO;
import com.realworld.entity.ProductTag;
import com.realworld.exception.EntityNotFoundException;
import com.realworld.repository.ProductTagRepository;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class ProductTagService {
  private final ProductTagRepository repository;

  @Autowired
  public ProductTagService(ProductTagRepository repository) {
    this.repository = repository;
  }

  public List<ProductTag> getProductTagsList() {
    return repository.findAll();
  }

  public ProductTag geProductTag(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product Tag", id));
  }

  public ProductTag createProductTag(ProductTagDTO productTagDTO) {

    var productTag = new ProductTag();
    productTag.setValue(productTagDTO.getValue());
    productTag.setMetaData(productTagDTO.getMetaData());
    return repository.save(productTag);
  }

  public boolean ifExists(Long id) {
    return repository.existsById(id);
  }

  public boolean ifExistsByName(String value) {
    return repository.existsProductTagsByValue(value);
  }

  public boolean ifExistsOrError(Long id) {
    if (repository.existsById(id)) {
      return true;
    }

    throw new EntityNotFoundException("Product Tag", id);
  }

  public boolean deleteProductTag(Long id) {
    repository.deleteById(id);
    return !repository.existsById(id);
  }

  public ProductTag updateProductTag(Long id, Map<String, Object> updates) {
    ProductTag productTag =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product Tag not found", id));
    //noinspection DuplicatedCode
    updates.forEach(
        (key, value) -> {
          Field field = ReflectionUtils.findField(ProductTag.class, key);
          if (field != null) {
            field.setAccessible(true);
          }
        });

    return repository.save(productTag);
  }
}
