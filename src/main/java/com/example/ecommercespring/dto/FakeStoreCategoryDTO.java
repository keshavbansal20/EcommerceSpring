package com.example.ecommercespring.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreCategoryDTO  {
    private List<String> categories;

}
