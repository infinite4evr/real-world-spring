package com.realworld.controller;

import com.realworld.DTO.InventoryItemDTO;
import com.realworld.annotations.HandleInvalidBody.HandleInvalidBody;
import com.realworld.entity.InventoryItem;
import com.realworld.exception.GeneralException;
import com.realworld.service.InventoryItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/inventory-items")
public class InventoryItemController {

  private final InventoryItemService service;

  @Autowired
  public InventoryItemController(InventoryItemService service) {
    this.service = service;
  }

  @GetMapping("")
  public List<InventoryItem> listProductCategory() {
    return service.getInventoryItemList();
  }

  @GetMapping("/{InventoryItem}")
  public ResponseEntity<Object> getInventoryItem(@PathVariable @Positive Long tagId) {
    return ResponseEntity.ok().body(service.getInventoryItem(tagId));
  }

  @PostMapping("")
  @HandleInvalidBody
  public ResponseEntity<Object> createInventoryItem(
      @Valid @RequestBody InventoryItemDTO inventoryItemDTO) throws Exception {
    if (service.ifExistsByName(inventoryItemDTO.getTitle())) {
      throw new GeneralException("Entity already exist", "The name already exist");
    }
    return ResponseEntity.ok(service.createInventoryItem(inventoryItemDTO));
  }

  @PatchMapping("/{inventoryItemId}")
  @HandleInvalidBody
  public ResponseEntity<Object> updateInventoryItem(
      @PathVariable @Positive Long inventoryItemId, @RequestBody Map<String, Object> updates) {
    return ResponseEntity.ok().body(service.updateInventoryItem(inventoryItemId, updates));
  }

  @DeleteMapping("/{inventoryItemId}")
  public ResponseEntity<Object> deleteInventoryItem(@PathVariable @Positive Long inventoryItemId) {
    if (service.ifExistsOrError(inventoryItemId)) {
      if (service.deleteInventoryItem(inventoryItemId)) {
        return ResponseEntity.ok().body(null);
      }
    }

    throw new GeneralException();
  }
}
