package com.project.crud.service;

import com.project.crud.entity.Product;
import com.project.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
// -------------------------POST(CREATE) METHODS---------------------------
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
//---------------------------GET(READ) METHODS------------------------------
    public List<Product> getProducts(){ //list of all products
        return repository.findAll();
    }
    public Product getProductById(int id){ // fetching single product by id
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){ // fetching single product by name
        return repository.findByName(name);
    }
//---------------------------DELETE METHODS------------------------------
    public String deleteProduct(int id)
    {
        repository.deleteById(id);
        return "product removed" + id;
    }
//---------------------------UPDATE(PUT) METHODS------------------------------
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
