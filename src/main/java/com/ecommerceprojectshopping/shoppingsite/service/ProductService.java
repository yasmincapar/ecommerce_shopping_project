package com.ecommerceprojectshopping.shoppingsite.service;

import com.ecommerceprojectshopping.shoppingsite.model.Product;
import com.ecommerceprojectshopping.shoppingsite.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
