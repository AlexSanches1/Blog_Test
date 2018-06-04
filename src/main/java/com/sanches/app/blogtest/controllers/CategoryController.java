package com.sanches.app.blogtest.controllers;

import com.sanches.app.blogtest.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity createCategoryByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(categoryService.createCategory(name));
    }

    @GetMapping("/list")
    public ResponseEntity ListCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/byId")
    public ResponseEntity getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
}
