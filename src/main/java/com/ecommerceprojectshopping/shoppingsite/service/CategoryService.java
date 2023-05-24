package com.ecommerceprojectshopping.shoppingsite.service;

import com.ecommerceprojectshopping.shoppingsite.model.Category;
import com.ecommerceprojectshopping.shoppingsite.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    public List<Category> findAll() {
        return repository.findAll();
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }
}
