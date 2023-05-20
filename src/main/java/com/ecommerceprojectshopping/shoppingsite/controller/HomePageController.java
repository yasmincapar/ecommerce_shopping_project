package com.ecommerceprojectshopping.shoppingsite.controller;

import com.ecommerceprojectshopping.shoppingsite.model.Product;
import com.ecommerceprojectshopping.shoppingsite.model.User;
import com.ecommerceprojectshopping.shoppingsite.service.CategoryService;
import com.ecommerceprojectshopping.shoppingsite.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageController {
    private final ProductService productservice;
    private final CategoryService categoryservice;


    @GetMapping("/")//GET is used to retrieve data from the server.
    public String index(Model model){
        model.addAttribute("products",productservice.getAllProducts());
        //we aget all products list using getAllProducts() then we put that into products which is then storeed in the Model object to then further use in the view
        model.addAttribute("productsCount", productservice.productsCount());
        //thanks to the Model obkject we can pass data to the view
        User user=new User();//we create new User object to pass to the view then with .add we add the user object to the Model
        //This makes the user object available to the view template for rendering.
        model.addAttribute("categories", categoryservice.findAll());
        model.addAttribute("user",user);
        return "practice_homepage";
    }

}
