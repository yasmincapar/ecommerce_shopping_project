package com.ecommerceprojectshopping.shoppingsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ImageUploadController {
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("imageFile") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Save the file to a specific directory or perform any necessary operations
                String fileName = file.getOriginalFilename();
                File destFile = new File("C:/ALL_MY_SPRINGBOOT_PROJECTS/shoppingsite/src/main/resources/static/images", fileName);
                file.transferTo(destFile);
                // Return the file name or any other response as needed
                return "File uploaded successfully: " + fileName;
            } catch (IOException e) {
                // Handle the exception
                return "File upload failed: " + e.getMessage();
            }
        } else {
            return "No file selected.";
        }
    }
}
