package com.example.dtos.convertor;

import com.example.dtos.ProductDto;
import com.example.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConvertor {

    private final ProductCategoryDtoConvertor productCategoryDtoConvertor;

    public ProductDtoConvertor( ProductCategoryDtoConvertor productCategoryDtoConvertor) {
        this.productCategoryDtoConvertor = productCategoryDtoConvertor;
    }


    public ProductDto convertToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                productCategoryDtoConvertor.convertToProductCategoryDto(product.getCategory()),
                product.getProductName(),
                product.getUnitPrice(),
                product.getUnitsInStock(),
                product.getQuantityPerUnit()
        );




    }






}
