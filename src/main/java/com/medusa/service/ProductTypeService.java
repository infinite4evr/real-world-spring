package com.medusa.service;

import com.medusa.DTO.ProductTypeDTO;
import com.medusa.entity.ProductType;
import com.medusa.exception.EntityNotFoundException;
import com.medusa.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ProductTypeService {
    final private ProductTypeRepository repository;

    @Autowired
    public ProductTypeService(ProductTypeRepository repository) {
        this.repository = repository;
    }

    public List<ProductType> getProductTypeList() {
        return repository.findAll();
    }

    public ProductType getProductType(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sales Channel ", id));
    }

    public ProductType createProductType(ProductTypeDTO ProductTypeDTO) {
        ProductType productType = ProductType.builder().
                value(ProductTypeDTO.getValue())
                .build();
        return repository.save(productType);
    }

    public boolean ifExists(Long id) {
        return repository.existsById(id);
    }

    public boolean ifExistsByName(String value) {
        return repository.existsProductTypeByName(value);
    }

    public boolean ifExistsOrError(Long id) {
        if (repository.existsById(id)) {
            return true;
        }

        throw new EntityNotFoundException("Sales Channel", id);
    }

    public boolean deleteProductType(Long id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }

    public ProductType updateProductType(Long id, Map<String, Object> updates) {


        ProductType ProductType = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sales Channel not found", id));

        //noinspection DuplicatedCode
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(ProductType.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, ProductType, value);
            }

        });


        return repository.save(ProductType);
    }


}
