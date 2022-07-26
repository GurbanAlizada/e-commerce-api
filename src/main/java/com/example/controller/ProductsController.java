package com.example.controller;


import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import com.example.dtos.ProductWithCategoryDto;
import com.example.model.Product;
import com.example.service.inter.ProductServiceInter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    private ProductServiceInter productServiceInter;

    public ProductsController(ProductServiceInter productServiceInter) {
        this.productServiceInter = productServiceInter;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return productServiceInter.getAll();
    }


    @PostMapping("/addProduct")
    Result add(@RequestBody Product product){
        return productServiceInter.add(product);
    }

    @GetMapping("/{id}")
    public DataResult<Product> getById(@PathVariable("id") int id){
        return productServiceInter.getById(id);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAllByPage(@RequestParam("pageNo") int pageNo ,@RequestParam("pageSize") int pageSize){
        return productServiceInter.getAllByPage(pageNo,pageSize);
    }


    @GetMapping("/getAllBySorted")
    public DataResult<List<Product>> getAllBySorted(){
        return productServiceInter.getAllBySorted();
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam("productName") String productName) {
        return productServiceInter.getByProductName(productName);
    }


    @GetMapping("getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
        return productServiceInter.getByProductNameAndCategory_CategoryId(productName , categoryId);
    }


    @GetMapping("/getByProductNameOrCategory")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam("productName")String productName,@RequestParam("categoryId") int categoryId) {
       return productServiceInter.getByProductNameOrCategory_CategoryId(productName , categoryId);
    }




    @GetMapping("/getByCategory_CategoryIdIn")
    DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam("/categories") List<Integer> categories){
        return productServiceInter.getByCategory_CategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName){

        return productServiceInter.getByProductNameContains(productName);
    }


    @GetMapping("/getByProductNameStartsWith")
    DataResult<List<Product>> getByProductNameStartsWith(@RequestParam("name") String name){
        return productServiceInter.getByProductNameStartsWith(name);
    }

    @GetMapping("/getByNameAndCategory")
    DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName ,@RequestParam("categoryId")  int categoryId){
        return productServiceInter.getByNameAndCategory(productName, categoryId);
    }



    @GetMapping("/getProductWithCategoryDto")
    public  DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDto(){
        return productServiceInter.getProductWithCategoryDto();
    }




}
