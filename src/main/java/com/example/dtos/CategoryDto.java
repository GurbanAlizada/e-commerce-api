package com.example.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {

    private int id;
    private String categoryName;
    private List<CategoryProductDto> products;
}
