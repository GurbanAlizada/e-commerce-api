package com.example.controller;


import com.example.dtos.ProductDto;
import com.example.dtos.request.ProductRequest;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import com.example.dtos.ProductWithCategoryDto;
import com.example.service.inter.ProductServiceInter;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResult<List<ProductDto>>> getAll() {
        return ResponseEntity.ok(productServiceInter.getAll());
    }


    @PostMapping("/addProduct")
    ResponseEntity<Result> add(@Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productServiceInter.add(productRequest));
    }

    @DeleteMapping ("/deleteProduct/{id}")
    public ResponseEntity<Result> deleteProduct(@PathVariable("id") int id){
        return ResponseEntity.ok(productServiceInter.deleteProduct(id));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Result> updateProduct(@PathVariable("id") int id , @Valid @RequestBody  ProductRequest productRequest){
        return ResponseEntity.ok(productServiceInter.updateProduct(id, productRequest));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DataResult<ProductDto>> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(productServiceInter.getById(id));
    }


    @GetMapping("/getAllByPage")
    public ResponseEntity<DataResult<List<ProductDto>>> getAllByPage(@RequestParam("pageNo") int pageNo ,@RequestParam("pageSize") int pageSize){
        return ResponseEntity.ok(productServiceInter.getAllByPage(pageNo,pageSize));
    }


    @GetMapping("/getAllBySorted")
    public ResponseEntity<DataResult<List<ProductDto>>> getAllBySorted(){
        return ResponseEntity.ok(productServiceInter.getAllBySorted());
    }

    @GetMapping("/getByProductName")
    public ResponseEntity<DataResult<ProductDto>> getByProductName(@RequestParam("productName") String productName) {
        return ResponseEntity.ok(productServiceInter.getByProductName(productName));
    }


    @GetMapping("getByProductNameAndCategory")
    public ResponseEntity<DataResult<ProductDto>> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
        return ResponseEntity.ok(productServiceInter.getByProductNameAndCategory_CategoryId(productName , categoryId));
    }


    @GetMapping("/getByProductNameOrCategory")
    public ResponseEntity<DataResult<List<ProductDto>>> getByProductNameOrCategory_CategoryId(@RequestParam("productName")String productName,@RequestParam("categoryId") int categoryId) {
       return ResponseEntity.ok(productServiceInter.getByProductNameOrCategory_CategoryId(productName , categoryId));
    }




    @GetMapping("/getByCategory_CategoryIdIn")
    ResponseEntity<DataResult<List<ProductDto>>> getByCategory_CategoryIdIn(@RequestParam("/categories") List<Integer> categories){
        return ResponseEntity.ok(productServiceInter.getByCategory_CategoryIdIn(categories));
    }

    @GetMapping("/getByProductNameContains")
    ResponseEntity<DataResult<List<ProductDto>>> getByProductNameContains(@RequestParam("productName") String productName){

        return ResponseEntity.ok(productServiceInter.getByProductNameContains(productName));
    }


    @GetMapping("/getByProductNameStartsWith")
    ResponseEntity<DataResult<List<ProductDto>>> getByProductNameStartsWith(@RequestParam("name") String name){
        return ResponseEntity.ok(productServiceInter.getByProductNameStartsWith(name));
    }

    @GetMapping("/getByNameAndCategory")
    ResponseEntity<DataResult<List<ProductDto>>> getByNameAndCategory(@RequestParam("productName") String productName ,@RequestParam("categoryId")  int categoryId){
        return ResponseEntity.ok(productServiceInter.getByNameAndCategory(productName, categoryId));
    }



    @GetMapping("/getProductWithCategoryDto")
    public  ResponseEntity<DataResult<List<ProductWithCategoryDto>>> getProductWithCategoryDto(){
        return  ResponseEntity.ok(productServiceInter.getProductWithCategoryDto());
    }




}
