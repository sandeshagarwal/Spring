package com.project.crud.controller;

import com.project.crud.entity.Product;
import com.project.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
//------------------------POST(CREATE) APIS---------------------------
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
//-------------------------GET(READ) APIS------------------------------
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }
 //-------------------------UPDATE(PUT) APIS------------------------------
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
 //-------------------------DELETE APIS------------------------------
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return service.deleteProduct(id);
    }
}
