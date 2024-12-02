package com.realworld.controller;

import com.realworld.DTO.ProductCollectionDTO;
import com.realworld.annotations.HandleInvalidBody.HandleInvalidBody;
import com.realworld.entity.ProductCollection;
import com.realworld.exception.GeneralException;
import com.realworld.service.ProductCollectionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/collections")
public class ProductCollectionController {

  private final ProductCollectionService service;

  @Autowired
  public ProductCollectionController(ProductCollectionService service) {
    this.service = service;
  }

  @GetMapping("")
  public List<ProductCollection> listProductCollection() {
    return service.getProductCollectionList();
  }

  @GetMapping("/{ProductCollectionId}")
  public ResponseEntity<Object> getProductCollection(@PathVariable @Positive Long channelId) {
    return ResponseEntity.ok().body(service.getProductCollection(channelId));
  }

  @PostMapping("")
  @HandleInvalidBody
  public ResponseEntity<Object> createProductCollection(
      @Valid @RequestBody ProductCollectionDTO ProductCollectionDTO) throws Exception {
    if (service.ifExistsByName(ProductCollectionDTO.getTitle())) {
      throw new GeneralException("Entity already exist", "The name already exist");
    }

    return ResponseEntity.ok(service.createProductCollection(ProductCollectionDTO));
  }

  @PatchMapping("/{ProductCollectionId}")
  @HandleInvalidBody
  public ResponseEntity<Object> updateProductCollection(
      @PathVariable @Positive Long ProductCollectionId, @RequestBody Map<String, Object> updates) {
    System.out.println(updates);
    return ResponseEntity.ok().body(service.updateProductCollection(ProductCollectionId, updates));
  }

  @DeleteMapping("/{ProductCollectionId}")
  public ResponseEntity<Object> deleteProductTag(@PathVariable @Positive Long ProductCollectionId) {
    if (service.ifExistsOrError(ProductCollectionId)) {
      if (service.deleteProductCollection(ProductCollectionId)) {
        return ResponseEntity.ok().body(null);
      }
    }

    throw new GeneralException();
  }
}
