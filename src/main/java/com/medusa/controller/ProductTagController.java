package com.medusa.controller;

import com.medusa.DTO.ProductTagDTO;
import com.medusa.annotations.HandleInvalidBody.HandleInvalidBody;
import com.medusa.entity.ProductTag;
import com.medusa.exception.GeneralException;
import com.medusa.service.ProductTagService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product-tags")
public class ProductTagController {

  private final ProductTagService service;

  @Autowired
  public ProductTagController(ProductTagService service) {
    this.service = service;
  }

  @GetMapping("")
  public List<ProductTag> listProductCategory() {
    return service.getProductTagsList();
  }

  @GetMapping("/{tagId}")
  public ResponseEntity<Object> getCategory(@PathVariable @Positive Long tagId) {
    return ResponseEntity.ok().body(service.geProductTag(tagId));
  }

  @PostMapping("")
  @HandleInvalidBody
  public ResponseEntity<Object> createCategory(@Valid @RequestBody ProductTagDTO productTagDTO)
      throws Exception {
    if (service.ifExistsByName(productTagDTO.getValue())) {
      throw new GeneralException("Entity already exist", "The name already exist");
    }

    return ResponseEntity.ok(service.createProductTag(productTagDTO));
  }

  @PatchMapping("/{productTagId}")
  @HandleInvalidBody
  public ResponseEntity<Object> updateProductTag(
      @PathVariable @Positive Long productTagId, @RequestBody Map<String, Object> updates) {
    return ResponseEntity.ok().body(service.updateProductTag(productTagId, updates));
  }

  @DeleteMapping("/{productTagId}")
  public ResponseEntity<Object> deleteProductTag(@PathVariable @Positive Long productTagId) {
    if (service.ifExistsOrError(productTagId)) {
      if (service.deleteProductTag(productTagId)) {
        return ResponseEntity.ok().body(null);
      }
    }

    throw new GeneralException();
  }
}
