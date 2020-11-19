package com.project.crud.repository;

import com.project.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>
{

    Product findByName(String name);
}
