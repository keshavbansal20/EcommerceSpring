package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.dto.FakeStoreCategoryDTO;
import com.example.ecommercespring.gateway.api.FakeStoreCategoryAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component //for gateway no annotation by spring so define by @Component annotation
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryAPI fakeStoreCategoryAPI;

    //DI
    public FakeStoreCategoryGateway(FakeStoreCategoryAPI _fakeStoreCategoryAPI){
        this.fakeStoreCategoryAPI = _fakeStoreCategoryAPI;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryDTO response = this.fakeStoreCategoryAPI.getAllFakeCategories().execute().body();
        if(response == null){
            throw new IOException("Fetch to failed categories from fakestoreapi");
        }
        return response.getCategories().stream()
                .map(
                        category -> CategoryDTO.builder()
                                .name(category)
                                .build())
                .collect(Collectors.toList());
    }

}
