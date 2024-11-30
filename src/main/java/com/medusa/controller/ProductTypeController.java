package com.medusa.controller;

import com.medusa.DTO.ProductTypeDTO;
import com.medusa.annotations.HandleInvalidBody.HandleInvalidBody;
import com.medusa.entity.ProductType;
import com.medusa.exception.GeneralException;
import com.medusa.service.ProductTypeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product-types")
public class ProductTypeController {

  private final ProductTypeService service;

  @Autowired
  public ProductTypeController(ProductTypeService service) {
    this.service = service;
  }

  @GetMapping("")
  public List<ProductType> listProductCategory() {
    return service.getProductTypeList();
  }

  @GetMapping("/{productType}")
  public ResponseEntity<Object> getProductType(@PathVariable @Positive Long tagId) {
    return ResponseEntity.ok().body(service.getProductType(tagId));
  }

  @PostMapping("")
  @HandleInvalidBody
  public ResponseEntity<Object> createProductType(@Valid @RequestBody ProductTypeDTO ProductTypeDTO)
      throws Exception {
    if (service.ifExistsByName(ProductTypeDTO.getValue())) {
      throw new GeneralException("Entity already exist", "The name already exist");
    }
    return ResponseEntity.ok(service.createProductType(ProductTypeDTO));
  }

  @PatchMapping("/{ProductTypeId}")
  @HandleInvalidBody
  public ResponseEntity<Object> updateProductType(
      @PathVariable @Positive Long ProductTypeId, @RequestBody Map<String, Object> updates) {
    return ResponseEntity.ok().body(service.updateProductType(ProductTypeId, updates));
  }

  @DeleteMapping("/{ProductTypeId}")
  public ResponseEntity<Object> deleteProductType(@PathVariable @Positive Long ProductTypeId) {
    if (service.ifExistsOrError(ProductTypeId)) {
      if (service.deleteProductType(ProductTypeId)) {
        return ResponseEntity.ok().body(null);
      }
    }

    throw new GeneralException();
  }
}
