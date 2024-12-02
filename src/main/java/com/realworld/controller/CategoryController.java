package com.realworld.controller;

import com.realworld.DTO.ProductCategoryDTO;
import com.realworld.annotations.HandleInvalidBody.HandleInvalidBody;
import com.realworld.entity.ProductCategory;
import com.realworld.exception.GeneralException;
import com.realworld.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product-categories")
public class CategoryController {

  private final CategoryService service;

  @Autowired
  public CategoryController(CategoryService service) {
    this.service = service;
  }

  @GetMapping("")
  public List<ProductCategory> listProductCategory() {
    return service.getCategoryList();
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<Object> getCategory(@PathVariable @Positive Long categoryId) {
    return ResponseEntity.ok().body(service.getCategory(categoryId));
  }

  @PostMapping("")
  @HandleInvalidBody
  public ResponseEntity<Object> createCategory(
      @Valid @RequestBody ProductCategoryDTO productCategoryDTO) throws Exception {
    if (service.ifExistsByName(productCategoryDTO.getName())) {
      throw new GeneralException("Entity already exist", "The name already exist");
    }

    return ResponseEntity.ok(service.createCategory(productCategoryDTO));
  }

  @PatchMapping("/{categoryId}")
  @HandleInvalidBody
  public ResponseEntity<Object> updateCategory(
      @PathVariable @Positive Long categoryId, @RequestBody Map<String, Object> updates) {
    return ResponseEntity.ok().body(service.updateCategory(categoryId, updates));
  }

  @DeleteMapping("/{categoryId}")
  public ResponseEntity<Object> deleteCategory(@PathVariable @Positive Long categoryId) {
    if (service.ifExistsOrError(categoryId)) {
      if (service.deleteCategory(categoryId)) {
        return ResponseEntity.ok().body(null);
      }
    }

    throw new GeneralException();
  }

  @GetMapping("/custom-query-list")
  public ResponseEntity<?> getCategoryList() {
    return ResponseEntity.ok().body(service.getCustomQueryList());
  }
}
