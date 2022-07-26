package com.example.service.impl;

import com.example.dtos.ProductDto;
import com.example.dtos.request.ProductRequest;
import com.example.model.Category;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import com.example.utilities.results.SuccessDataResult;
import com.example.utilities.results.SuccessResult;
import com.example.dtos.ProductWithCategoryDto;
import com.example.dtos.convertor.ProductDtoConvertor;
import com.example.exception.ProductNotFoundException;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.inter.ProductServiceInter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductServiceInter {


    private final ProductRepository productRepository;
    private final ProductDtoConvertor productDtoConvertor;
    private final CategoryServiceImpl categoryService;


    public ProductServiceImpl(ProductRepository productRepository,
                              ProductDtoConvertor productDtoConvertor,
                              CategoryServiceImpl categoryService) {

        this.productRepository = productRepository;
        this.productDtoConvertor = productDtoConvertor;
        this.categoryService = categoryService;
    }

    @Override
    public DataResult<List<ProductDto>> getAll() {
        List<Product> products =  productRepository.findAll();
        return new SuccessDataResult<>(
                products.stream()
                        .map(n->productDtoConvertor.convertToProductDto(n))
                        .collect(Collectors.toList()) ,
                "Urun listelendi"
        );
    }


    @Override
    public DataResult<List<ProductDto>> getAllByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        List<Product> products = productRepository.findAll(pageable).getContent();
        return new SuccessDataResult<>(
                products.stream()
                        .map(n->productDtoConvertor.convertToProductDto(n))
                        .collect(Collectors.toList()),
                "Data Listelendi"

        );
    }

    @Override
    public DataResult<List<ProductDto>> getAllBySorted(){
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        List<Product> products = productRepository.findAll(sort);
        return new SuccessDataResult<>(
                products.stream()
                        .map(n->productDtoConvertor.convertToProductDto(n))
                        .collect(Collectors.toList()),
                "Data Listelendi"
        );
    }


    @Override
    @Transactional
    public Result add(ProductRequest productRequest) {
        Category category = categoryService.findCategoryById(productRequest.getCategoryId());
        Product product = new Product(
                0,
                category,
                productRequest.getProductName(),
                productRequest.getUnitPrice(),
                productRequest.getUnitsInStock(),
                productRequest.getQuantityPerUnit()
        );
        productRepository.save(product);
        return new SuccessResult("Urun eklendi");
    }


    @Override
    @Transactional
    public Result deleteProduct(int id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Urun Bulunamadi"));
        productRepository.delete(product);
        return new SuccessResult("Urun Silindi");
    }

    @Override
    @Transactional
    public Result updateProduct(int id ,ProductRequest productRequest) {
        Product product = productRepository.findById(id)
        .orElseThrow(()->new ProductNotFoundException("Urun Bulunamadi"));
        Category category = categoryService.findCategoryById(productRequest.getCategoryId());
        product.setCategory(category);
        product.setProductName(productRequest.getProductName());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setQuantityPerUnit(productRequest.getQuantityPerUnit());
        product.setUnitsInStock(productRequest.getUnitsInStock());
        productRepository.save(product);
        return new SuccessResult("Urun basari ile guncellendi");
    }


    @Override
    public DataResult<ProductDto> getById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Urun Bulunamadi"));
      return new SuccessDataResult<>(
              productDtoConvertor.convertToProductDto(product),
              "Urun Listelendi"
      );
    }



    @Override
    public DataResult<ProductDto> getByProductName(String productName) {
       Product product =  productRepository.getByProductName(productName);
       return new SuccessDataResult<>(
               productDtoConvertor.convertToProductDto(product),
               "Data Listelendi"
       );
    }


    @Override
    public DataResult<ProductDto> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        Product product = productRepository.getByProductNameAndCategory_CategoryId(productName ,categoryId);
        return new SuccessDataResult<>(
                productDtoConvertor.convertToProductDto(product),
                "Data Listelendi"
        );
    }


    @Override
    public DataResult<List<ProductDto>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
       List<Product> products = productRepository.getByProductNameOrCategory_CategoryId(productName,categoryId);
       return new SuccessDataResult<>(
               products.stream()
                       .map(n->productDtoConvertor.convertToProductDto(n))
                       .collect(Collectors.toList()),
               "Data Listelendi"
       );
    }


    @Override
    public DataResult<List<ProductDto>> getByCategory_CategoryIdIn(List<Integer> categories) {
       List<Product> products = productRepository.getByCategory_CategoryIdIn(categories);
       return new SuccessDataResult<>(
               products.stream()
                       .map(n->productDtoConvertor.convertToProductDto(n))
                       .collect(Collectors.toList()),
               "Data Listelendi"
       );
    }



    @Override
    public DataResult<List<ProductDto>> getByProductNameContains(String productName) {

       List<Product> products = productRepository.getByProductNameContains(productName);
       return new SuccessDataResult<>(
               products.stream().map(n->productDtoConvertor.convertToProductDto(n)).collect(Collectors.toList()),
               "Data Listelendi"
       );
    }



    @Override
    public DataResult<List<ProductDto>> getByProductNameStartsWith(String name) {
      List<Product> products = productRepository.getByProductNameStartsWith(name);
      return new SuccessDataResult<>(
              products.stream()
                      .map(n->productDtoConvertor.convertToProductDto(n))
                      .collect(Collectors.toList()),
              "Data Listelendi"
      );
    }


    @Override
    public DataResult<List<ProductDto>> getByNameAndCategory(String productName, int categoryId) {
       List<Product> products =  productRepository.getByNameAndCategory(productName ,categoryId);
       return new SuccessDataResult<>(
               products.stream()
                       .map(n->productDtoConvertor.convertToProductDto(n))
                       .collect(Collectors.toList()),
               "Data Listelendi"
       );
    }


    @Override
    public  DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDto() {
        return new SuccessDataResult<>(
                productRepository.getProductWithCategoryDto(),
                "Data Listelendi"
        );
    }


}
