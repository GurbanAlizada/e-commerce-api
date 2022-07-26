package com.example.controller;


import com.example.dtos.ProductDto;
import com.example.dtos.request.ProductRequest;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import com.example.dtos.ProductWithCategoryDto;
import com.example.service.inter.ProductServiceInter;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    private final ProductServiceInter productServiceInter;

    public ProductsController(ProductServiceInter productServiceInter) {
        this.productServiceInter = productServiceInter;
    }

    @GetMapping("/getall")
    public DataResult<List<ProductDto>> getAll() {
        return productServiceInter.getAll();
    }


    @PostMapping("/addProduct")
    Result add(@Valid @RequestBody ProductRequest productRequest){
        return productServiceInter.add(productRequest);
    }

    @PostMapping("/deleteProduct/{id}")
    public Result deleteProduct(@PathVariable("id") int id){
        return productServiceInter.deleteProduct(id);
    }

    @PostMapping("/updateUser/{id}")
    public Result updateProduct(@PathVariable("id") int id , @Valid @RequestBody  ProductRequest productRequest){
        return productServiceInter.updateProduct(id, productRequest);
    }


    @GetMapping("/{id}")
    public DataResult<ProductDto> getById(@PathVariable("id") int id){
        return productServiceInter.getById(id);
    }


    @GetMapping("/getAllByPage")
    public DataResult<List<ProductDto>> getAllByPage(@RequestParam("pageNo") int pageNo ,@RequestParam("pageSize") int pageSize){
        return productServiceInter.getAllByPage(pageNo,pageSize);
    }


    @GetMapping("/getAllBySorted")
    public DataResult<List<ProductDto>> getAllBySorted(){
        return productServiceInter.getAllBySorted();
    }

    @GetMapping("/getByProductName")
    public DataResult<ProductDto> getByProductName(@RequestParam("productName") String productName) {
        return productServiceInter.getByProductName(productName);
    }


    @GetMapping("getByProductNameAndCategory")
    public DataResult<ProductDto> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
        return productServiceInter.getByProductNameAndCategory_CategoryId(productName , categoryId);
    }


    @GetMapping("/getByProductNameOrCategory")
    public DataResult<List<ProductDto>> getByProductNameOrCategory_CategoryId(@RequestParam("productName")String productName,@RequestParam("categoryId") int categoryId) {
       return productServiceInter.getByProductNameOrCategory_CategoryId(productName , categoryId);
    }




    @GetMapping("/getByCategory_CategoryIdIn")
    DataResult<List<ProductDto>> getByCategory_CategoryIdIn(@RequestParam("/categories") List<Integer> categories){
        return productServiceInter.getByCategory_CategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    DataResult<List<ProductDto>> getByProductNameContains(@RequestParam("productName") String productName){

        return productServiceInter.getByProductNameContains(productName);
    }


    @GetMapping("/getByProductNameStartsWith")
    DataResult<List<ProductDto>> getByProductNameStartsWith(@RequestParam("name") String name){
        return productServiceInter.getByProductNameStartsWith(name);
    }

    @GetMapping("/getByNameAndCategory")
    DataResult<List<ProductDto>> getByNameAndCategory(@RequestParam("productName") String productName ,@RequestParam("categoryId")  int categoryId){
        return productServiceInter.getByNameAndCategory(productName, categoryId);
    }



    @GetMapping("/getProductWithCategoryDto")
    public  DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDto(){
        return productServiceInter.getProductWithCategoryDto();
    }




}
