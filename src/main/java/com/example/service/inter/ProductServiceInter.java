package com.example.service.inter;

import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import com.example.dtos.ProductWithCategoryDto;
import com.example.model.Product;

import java.util.List;

public interface ProductServiceInter {

    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAllByPage(int pageNo ,int pageSize);

    DataResult<List<Product>> getAllBySorted();

    Result add(Product product);

    DataResult<Product> getById(int  id);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName , int categoryId );

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName , int categoryId);

    DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String name);

    DataResult<List<Product>> getByNameAndCategory( String productName ,  int categoryId);


    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDto();


}
