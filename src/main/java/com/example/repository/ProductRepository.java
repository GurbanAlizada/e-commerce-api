package com.example.repository;

import com.example.dtos.ProductWithCategoryDto;
import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product , Integer> {


    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName , int categoryId );

    List<Product> getByProductNameOrCategory_CategoryId(String productName , int categoryId);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String name);

    @Query("from Product p where p.productName =:productName and  p.category.categoryId =:categoryId")
    List<Product> getByNameAndCategory(@Param("productName") String productName , @Param("categoryId") int categoryId);


    @Query("select new com.example.dtos.ProductWithCategoryDto" +
            "(p.id , p.productName , c.categoryName) " +
            "from Category c " +
            "inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDto();



}
