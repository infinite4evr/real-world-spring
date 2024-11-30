package com.medusa.service;

import com.medusa.DTO.ProductCollectionDTO;
import com.medusa.entity.ProductCollection;
import com.medusa.exception.EntityNotFoundException;
import com.medusa.repository.ProductCollectionRepository;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class ProductCollectionService {

  private final ProductCollectionRepository repository;

  @Autowired
  public ProductCollectionService(ProductCollectionRepository repository) {
    this.repository = repository;
  }

  public List<ProductCollection> getProductCollectionList() {
    return repository.findAll();
  }

  public ProductCollection getProductCollection(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("ProductCollection", id));
  }

  public ProductCollection createProductCollection(ProductCollectionDTO ProductCollectionDTO) {

    var productCollection =
        ProductCollection.builder()
            .title(ProductCollectionDTO.getTitle())
            .handle(ProductCollectionDTO.getHandle())
            .build();
    return repository.save(productCollection);
  }

  public boolean ifExists(Long id) {
    return repository.existsById(id);
  }

  public boolean ifExistsByName(String name) {
    return repository.existsProductCollectionByTitle(name);
  }

  public boolean ifExistsOrError(Long id) {
    if (repository.existsById(id)) {
      return true;
    }

    throw new EntityNotFoundException("ProductCollection", id);
  }

  public boolean deleteProductCollection(Long id) {
    repository.deleteById(id);
    return !repository.existsById(id);
  }

  public ProductCollection updateProductCollection(Long id, Map<String, Object> updates) {
    ProductCollection ProductCollection =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("ProductCollection not found", id));
    updates.forEach(
        (key, value) -> {
          Field field = ReflectionUtils.findField(ProductCollection.class, key);
          if (field != null) {
            field.setAccessible(true);
            ReflectionUtils.setField(field, ProductCollection, value);
          }
        });

    return repository.save(ProductCollection);
  }
}
