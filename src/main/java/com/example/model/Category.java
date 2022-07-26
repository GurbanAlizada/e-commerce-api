package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({
        "hibernateLazyInitializer" ,
        "handler" ,
        "products"
})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    //@JsonIgnore
    private List<Product> products = new ArrayList<>();



}
