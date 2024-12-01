package com.medusa.service;

import com.medusa.DTO.InventoryItemDTO;
import com.medusa.entity.InventoryItem;
import com.medusa.exception.EntityNotFoundException;
import com.medusa.repository.InventoryItemRepository;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class InventoryItemService {

  private final InventoryItemRepository repository;

  @Autowired
  public InventoryItemService(InventoryItemRepository repository) {
    System.out.println("Setting InventoryItem service" + repository);
    this.repository = repository;
  }

  public List<InventoryItem> getInventoryItemList() {
    return repository.findAll();
  }

  public InventoryItem getInventoryItem(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("InventoryItem", id));
  }

  public InventoryItem createInventoryItem(InventoryItemDTO inventoryItemDTO) {
    var inventoryItem =
        InventoryItem.builder()
            .id(inventoryItemDTO.getId())
            .description(inventoryItemDTO.getDescription())
            .height(inventoryItemDTO.getHeight())
            .hsCode(inventoryItemDTO.getHsCode())
            .midCode(inventoryItemDTO.getMidCode())
            .sku(inventoryItemDTO.getSku())
            .length(inventoryItemDTO.getLength())
            .material(inventoryItemDTO.getMaterial())
            .width(inventoryItemDTO.getWidth())
            .metadata(inventoryItemDTO.getMetadata())
            .originCountry(inventoryItemDTO.getOriginCountry())
            .requiresShipping(inventoryItemDTO.isRequiresShipping())
            .thumbnail(inventoryItemDTO.getThumbnail())
            .weight(inventoryItemDTO.getWeight())
            .title(inventoryItemDTO.getTitle())
            .build();

    return repository.save(inventoryItem);
  }

  public boolean ifExists(Long id) {
    return repository.existsById(id);
  }

  public boolean ifExistsByName(String name) {
    return repository.existsInventoryItemByTitle(name);
  }

  public boolean ifExistsOrError(Long id) {
    if (repository.existsById(id)) {
      return true;
    }

    throw new EntityNotFoundException("InventoryItem", id);
  }

  public boolean deleteInventoryItem(Long id) {
    repository.deleteById(id);
    return !repository.existsById(id);
  }

  public InventoryItem updateInventoryItem(Long id, Map<String, Object> updates) {
    InventoryItem inventoryItem =
        repository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("InventoryItem not found", id));
    updates.forEach(
        (key, value) -> {
          Field field = ReflectionUtils.findField(InventoryItem.class, key);
          if (field != null) {
            field.setAccessible(true);
            ReflectionUtils.setField(field, inventoryItem, value);
          }
        });

    return repository.save(inventoryItem);
  }
}
