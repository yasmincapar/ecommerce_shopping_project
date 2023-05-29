package com.ecommerceprojectshopping.shoppingsite.service;

import com.ecommerceprojectshopping.shoppingsite.model.Product;
import com.ecommerceprojectshopping.shoppingsite.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

private final ProductRepository productRepository;
    public List<Product> getAllProducts() {
    return productRepository.findAll();
    }

    public Long productsCount() {
        return productRepository.count();
    }

    /**
     * In this save_product method which is type Product is returning a new product
     * We are saving this newly created product into the database
     * @param product
     * @return
     */
    public Product add_product(Product product) {
        return productRepository.save(product);

    }


    public void deleteproductbyid(Integer id) {
        productRepository.findById(id);

    }
}
