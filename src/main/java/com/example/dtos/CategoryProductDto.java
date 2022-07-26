package com.example.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProductDto {


    private int id;

    private String productName;

    private double unitPrice;

    private short unitsInStock;

    private String quantityPerUnit;

}
