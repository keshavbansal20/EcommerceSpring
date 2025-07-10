package com.example.ecommercespring.dto;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String name;
    private Long id;
    private Instant createdAt;

}
