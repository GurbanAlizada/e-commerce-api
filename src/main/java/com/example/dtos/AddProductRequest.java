package com.example.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddProductRequest {


    @NotNull
    private String name;

    @NotNull
    @Positive
    private double unitPrice;

    @NotNull
    @Positive
    private short unitsInStock;

    @NotNull
    private String categoryName;


}
