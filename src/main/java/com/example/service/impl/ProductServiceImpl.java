package com.example.service.impl;

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

@Service
@Transactional
public class ProductServiceImpl implements ProductServiceInter {


    private final ProductRepository productRepository;
    private final ProductDtoConvertor productDtoConvertor;

    public ProductServiceImpl(ProductRepository productRepository, ProductDtoConvertor productDtoConvertor) {
        this.productRepository = productRepository;
        this.productDtoConvertor = productDtoConvertor;
    }



    @Override
    public DataResult<List<Product>> getAll() {
        List<Product> products =  productRepository.findAll();
       /* return new SuccessDataResult<>(
                products.stream()
                        .map(n->productDtoConvertor.convertToProductDto(n))
                        .collect(Collectors.toList()) ,
                "Urun listelendi"
        );*/
        return new SuccessDataResult<>(
                products,
                "Data Listelendi"
        );
    }


    @Override
    public DataResult<List<Product>> getAllByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<>(
                productRepository.findAll(pageable).getContent(),
                "Data Listelendi"
        );
    }

    public DataResult<List<Product>> getAllBySorted(){
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<>(
                productRepository.findAll(sort),
                "Data Listelendi"
        );
    }


    @Override
    public Result add(Product product) {
        productRepository.save(product);
        return new SuccessResult("Urun eklendi");
    }


    @Override
    public DataResult<Product> getById(int id) {
        return new SuccessDataResult<>(
                productRepository.findById(id)
                        .orElseThrow(
                                ()->new ProductNotFoundException("Aradiginiz urun bulunamadi")
                        ),
                "Data Listelendi"
        );
    }


    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(
                productRepository.getByProductName(productName),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(
                productRepository.getByProductNameAndCategory_CategoryId(productName ,categoryId),
                "Data Listelendi"
        );
    }


    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(
                productRepository.getByProductNameOrCategory_CategoryId(productName,categoryId),
                "Data Listelendi"
        );
    }


    @Override
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<>(
                productRepository.getByCategory_CategoryIdIn(categories),
                "Data Listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(
                productRepository.getByProductNameContains(productName),
                "Data Listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String name) {
        return new SuccessDataResult<>(
                productRepository.getByProductNameStartsWith(name),
                "Data listelendi"
        );
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(
                productRepository.getByNameAndCategory(productName ,categoryId),
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
