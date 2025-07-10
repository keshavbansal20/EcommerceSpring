package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductWithCategoryDTO;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService{
    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return null;
    }


    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        return null;
    }

    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        return null;
    }
}
