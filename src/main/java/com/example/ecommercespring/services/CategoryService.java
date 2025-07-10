package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.mappers.CategoryMapper;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class CategoryService implements ICategoryService{
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo){
        this.repo = repo;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> dtos = new ArrayList<>();
        for (Category category: repo.findAll()) {
            dtos.add(CategoryMapper.toDto(category));
        }
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category saved = repo.save(category);
        return CategoryMapper.toDto(saved);
    }

    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long id) throws Exception{
         Category category = repo.findById(id).orElseThrow(()-> new Exception("Category not found"));

         List<ProductDTO> productDTOSs = category.getProducts()
                 .stream()
                 .map(product -> ProductMapper.toDto(product))
                 .collect(Collectors.toList());
        return AllProductsOfCategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(productDTOSs)
                .build();
    }
}
