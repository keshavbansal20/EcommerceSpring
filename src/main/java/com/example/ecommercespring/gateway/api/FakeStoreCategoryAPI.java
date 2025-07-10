package com.example.ecommercespring.gateway.api;

import com.example.ecommercespring.dto.FakeStoreCategoryDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;


@Component
public interface FakeStoreCategoryAPI {
    @GET("products/category")
    Call<FakeStoreCategoryDTO> getAllFakeCategories() throws IOException;

}
