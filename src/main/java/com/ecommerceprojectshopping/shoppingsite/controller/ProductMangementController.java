package com.ecommerceprojectshopping.shoppingsite.controller;

import com.ecommerceprojectshopping.shoppingsite.model.Category;
import com.ecommerceprojectshopping.shoppingsite.model.Product;
import com.ecommerceprojectshopping.shoppingsite.model.User;
import com.ecommerceprojectshopping.shoppingsite.service.CategoryService;
import com.ecommerceprojectshopping.shoppingsite.service.ProductService;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


/**In this class we will be adding, deleting and updating a product.
 *
 */
@Controller
@RequiredArgsConstructor
public class ProductMangementController {
    private static final Logger logger2 = Logger.getLogger(ProductMangementController.class.getName());

    final private ProductService productService;
    final private CategoryService categoryService;
    @GetMapping("/productpagecontroller")
    public String goingtoassetpage(Model model, Product product, Category category){
        model.addAttribute("product", new Product());
        model.addAttribute("category",new Category());
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "add_product_page";
    }

    @PostMapping("/addnewproduct")
    public String createAsset(Model model,Product product) {
        productService.add_product(product);//when add user us pressed user should be saved
        model.addAttribute("message", "Congrats! You have added a product.");
        model.addAttribute("products", productService.getAllProducts());
        //we aget all products list using getAllProducts() then we put that into products which is then storeed in the Model object to then further use in the view
        model.addAttribute("productsCount", productService.productsCount());
        //thanks to the Model obkject we can pass data to the view
        User user = new User();//we create new User object to pass to the view then with .add we add the user object to the Model
        //This makes the user object available to the view template for rendering.
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("user", user);
        return "add_product_page";

    }

        @GetMapping("/delete_product/{id}")
        public String deleteauser(@PathVariable("id") Integer id, @ModelAttribute Product product, Model model, HttpSession session) {
            try {
                productService.deleteproductbyid(id);
                //so the template knows this exist
                model.addAttribute("allproducts", productService.getAllProducts());
                return "home_page";
            } catch (Exception e) {
                return e.getMessage();
            }
        }}

