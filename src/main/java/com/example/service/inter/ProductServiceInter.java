package com.example.service.inter;

import com.example.dtos.ProductDto;
import com.example.dtos.request.ProductRequest;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import com.example.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductServiceInter {

    DataResult<List<ProductDto>> getAll();

    DataResult<List<ProductDto>> getAllByPage(int pageNo ,int pageSize);

    DataResult<List<ProductDto>> getAllBySorted();

     Result add(ProductRequest productRequest) ;

     Result deleteProduct(int id);

     Result updateProduct( int id , ProductRequest productRequest);

    DataResult<ProductDto> getById(int  id);

    DataResult<ProductDto> getByProductName(String productName);

    DataResult<ProductDto> getByProductNameAndCategory_CategoryId(String productName , int categoryId );

    DataResult<List<ProductDto>> getByProductNameOrCategory_CategoryId(String productName , int categoryId);

    DataResult<List<ProductDto>> getByCategory_CategoryIdIn(List<Integer> categories);

    DataResult<List<ProductDto>> getByProductNameContains(String productName);

    DataResult<List<ProductDto>> getByProductNameStartsWith(String name);

    DataResult<List<ProductDto>> getByNameAndCategory( String productName ,  int categoryId);


    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDto();


}
