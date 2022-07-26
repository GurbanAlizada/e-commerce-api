package com.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int id;

    private ProductCategoryDto productCategoryDto;

    private String productName;

    private double unitPrice;

    private short unitsInStock;

    private String quantityPerUnit;



}
