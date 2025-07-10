package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class FakeStoryCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;

    public FakeStoryCategoryService(ICategoryGateway categoryGateway){
        this.categoryGateway = categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }


    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }

    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception {
        return null;
    }
}
