package com.sanches.app.blogtest.services;

import com.sanches.app.blogtest.exceptions.NotFoundException;
import com.sanches.app.blogtest.models.Category;
import com.sanches.app.blogtest.models.dto.CategoryDTO;
import com.sanches.app.blogtest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ConvertService convertService;

    public CategoryDTO createCategory(String name) {
        Category category = new Category();
        CategoryDTO dto = new CategoryDTO();
        if (name != null && !name.equals(" ")) {
            category.setName(name);
            if (!alreadyExist(category.getName())) {
                Category saveData = categoryRepository.save(category);
                dto.setCategory(name);
                dto.setId(category.getId());
            } else {
                throw new NotFoundException();
            }

        }
        return dto;
    }

    public List<CategoryDTO> getAllCategory() {
        List<Category> list = categoryRepository.findAll();
        return list.stream()
                .map(category -> convertService.convertToDTO(category))
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategory(Long id) {
        try {
            Category category = categoryRepository.getOne(id);
            return convertService.convertToDTO(category);
        } catch (Exception e) {
            if (e instanceof EntityNotFoundException) {
                throw new NotFoundException();
            }
        }
        return null;
    }

    public boolean alreadyExist(String name) {
        List<Category> categories = categoryRepository.findByName(name);
        return categories != null && categories.size() > 0;
    }
}