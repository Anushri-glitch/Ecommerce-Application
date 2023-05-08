package com.Shrishti.EcommerceApplication.Controller;

import com.Shrishti.EcommerceApplication.Model.Product;
import com.Shrishti.EcommerceApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value="/product")
    public String createProduct(@RequestBody List<Product> product){
        return productService.createProduct(product);
    }

    //Get All Products Based On Category(Query Params)
    @GetMapping(value = "/productCategory")
    public List<Product> getAllProductsByCategory(@RequestParam String category){
        return productService.getAllProductsByCategory(category);
    }
    //Delete Products Based On ProductId
    @DeleteMapping(value = "/product")
    public String deleteById(@RequestParam Integer productId){
        return productService.deleteById(productId);
    }
}
