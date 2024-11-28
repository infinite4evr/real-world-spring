package com.medusa.controller;

import com.medusa.DTO.ProductCategoryDTO;
import com.medusa.annotations.HandleInvalidBody.HandleInvalidBody;
import com.medusa.entity.ProductCategory;
import com.medusa.exception.GeneralException;
import com.medusa.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/product-categories")
public class CategoryController {

    final private CategoryService service;

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
    public ResponseEntity<Object> createCategory(@Valid @RequestBody ProductCategoryDTO productCategoryDTO) throws Exception {
        if (service.ifExistsByName(productCategoryDTO.getName())) {
            throw new GeneralException("Entity already exist", "The name already exist");
        }

        return ResponseEntity.ok(service.createCategory(productCategoryDTO));
    }

    @PatchMapping("/{categoryId}")
    @HandleInvalidBody
    public ResponseEntity<Object> updateCategory(@PathVariable @Positive Long categoryId, @RequestBody Map<String, Object> updates) {
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


}
