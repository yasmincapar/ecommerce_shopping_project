package com.ecommerceprojectshopping.shoppingsite.controller;

import com.ecommerceprojectshopping.shoppingsite.model.Category;
import com.ecommerceprojectshopping.shoppingsite.model.Product;
import com.ecommerceprojectshopping.shoppingsite.model.User;
import com.ecommerceprojectshopping.shoppingsite.service.CategoryService;
import com.ecommerceprojectshopping.shoppingsite.service.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**In this class we will be adding, deleting and updating a product.
 *
 */
@Controller
@RequiredArgsConstructor
public class ProductMangementController {
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
    public String createAsset(@Valid Product product, BindingResult result, Model theModel) {
        if (result.hasErrors()) {
            return "add_product_page";
        }

        productService.add_product(product);//when add user us pressed user should be saved
        return "main_homepage";
    }
}
