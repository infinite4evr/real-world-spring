package com.medusa.controller;

import com.medusa.DTO.ProductCategoryDTO;
import com.medusa.entity.ProductCategory;
import com.medusa.repository.CategoryRepository;
import com.medusa.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin/product-categories")
public class CategoryController {

    final private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service){
        this.service = service;
    }

    @GetMapping("/")
    public List<ProductCategory> listProductCategory(){
        return service.getCategoryList();
    }

    @PostMapping("/")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody ProductCategoryDTO productCategoryDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(getErrors(bindingResult));
        }

        return ResponseEntity.ok(service.createCategory(productCategoryDTO));
    }

    private Map<String, Object> getErrors(BindingResult bindingResult) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("status", "error");
        Map<String, List<String>> errorDetails = new HashMap<>();

        bindingResult.getFieldErrors().forEach(fieldError -> {
            System.out.println(fieldError.getField() + " " + fieldError.getRejectedValue() + " " + fieldError.getDefaultMessage());


            var fieldName = fieldError.getField();

            if(errorDetails.containsKey(fieldName)){
               errorDetails.get(fieldName).add(fieldError.getDefaultMessage());
            } else {
                errorDetails.put(fieldName, new ArrayList<>(Arrays.asList(fieldName + " " + fieldError.getDefaultMessage())));
            }


        });

        errors.put("errors", errorDetails);
        return errors;
    }
}
