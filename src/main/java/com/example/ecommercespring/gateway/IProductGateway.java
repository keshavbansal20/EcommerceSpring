package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public interface IProductGateway {
    ProductDTO getCategoryById(Long id) throws Exception;
}
