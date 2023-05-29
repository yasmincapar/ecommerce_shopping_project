package com.ecommerceprojectshopping.shoppingsite.repository;

import com.ecommerceprojectshopping.shoppingsite.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product delete(Integer id);
}
