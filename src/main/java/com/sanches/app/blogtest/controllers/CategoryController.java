package com.sanches.app.blogtest.controllers;

import com.sanches.app.blogtest.models.dto.RequestCategoryDTO;
import com.sanches.app.blogtest.repositories.CategoryRepository;
import com.sanches.app.blogtest.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/create")
    public ResponseEntity createCategoryByName(@RequestBody RequestCategoryDTO dto) {
        return ResponseEntity.ok(categoryService.createCategory(dto.getName()));
    }

    @GetMapping("/list")
    public ResponseEntity ListCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/byId")
    public ResponseEntity getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @GetMapping("/delete_category/byId")
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
