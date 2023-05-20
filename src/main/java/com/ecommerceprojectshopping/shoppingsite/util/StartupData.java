package com.ecommerceprojectshopping.shoppingsite.util;

import com.ecommerceprojectshopping.shoppingsite.model.*;
import com.ecommerceprojectshopping.shoppingsite.repository.CategoryRepository;
import com.ecommerceprojectshopping.shoppingsite.repository.ProductRepository;
import com.ecommerceprojectshopping.shoppingsite.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
//CommandLineRunner used to indicate that a bean shouldrun somespecific code when the Spring application has started


@Component
public class StartupData implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository1;

    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);

    @Override
    public void run(String... args) throws Exception {
       // logger.info("Application is starting NOW!!!...");
        userRepository1.save(User.builder().id(1).email("yasmin@admin.com").username("yasmin").password("1234").gender(Gender.FEMALE).confirmPassword("1234").role(Role.ADMINISTRATOR).build());
        userRepository1.save(User.builder().id(2).email("yasmin@admin.com").username("yasmin").password("1234").gender(Gender.FEMALE).confirmPassword("1234").role(Role.USER).build());
        categoryRepository.save(Category.builder().id(3).categoryName("Olive").build());
        categoryRepository.save(Category.builder().id(4).categoryName("OliveOil").build());
        productRepository.save(Product.builder().id(1L).price(BigDecimal.valueOf(24)).name("Green Olives").category(categoryRepository.findByCategoryName("Olive")).image_of_product("images/green_olives.webp").description_of_product("best olive oil ever").build());
        productRepository.save(Product.builder().id(2L).price(BigDecimal.valueOf(26)).name("Black Olives").category(categoryRepository.findByCategoryName("Olive")).image_of_product("images/blackolives.jpg").description_of_product("best olive oil ever").build());
     //   productRepository.save(Product.builder().id(3L).price(BigDecimal.valueOf(32)).category(categoryRepository.findByCategoryName("Olive")).name("Olive Oil 3").image_of_product("images/oliveoil1.jpg").description_of_product("best olive oil ever").build());
    //    productRepository.save(Product.builder().id(4L).price(BigDecimal.valueOf(28)).category(categoryRepository.findByCategoryName("Olive")).name("Olive Oil 4").image_of_product("images/anotheroliveoil.jpg").description_of_product("best olive oil ever").build());

    }
}
