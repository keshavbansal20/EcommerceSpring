package com.example.ecommercespring.controllers;


import com.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import com.example.ecommercespring.services.ICategoryService;
import com.example.ecommercespring.services.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("api/categories")

public class CategoryController{
    private final ICategoryService categoryService;
    private final ProductService productService;

    public CategoryController(ICategoryService _categoryService, ProductService productService){
        this.categoryService = _categoryService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
        List<CategoryDTO> result = this.categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }


    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO created = this.categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> getAllProductsOfCategory(@PathVariable Long id) throws Exception {
        AllProductsOfCategoryDTO dto = categoryService.getAllProductsOfCategory(id);
        return ResponseEntity.ok(dto);
    }

    @PostConstruct //to check controller detecy by sring or not
    public void init() {
        System.out.println("✅ CategoryController loaded");
    }



}
