package com.example.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotNull
    private int categoryId;

    @NotNull
    private String productName;

    @NotNull
    @Positive
    private double unitPrice;

    @NotNull
    @Positive
    private short unitsInStock;

    @NotNull
    @Positive
    private String quantityPerUnit;


}
