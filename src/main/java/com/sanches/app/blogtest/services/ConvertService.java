package com.sanches.app.blogtest.services;

import com.sanches.app.blogtest.models.Category;
import com.sanches.app.blogtest.models.dto.CategoryDTO;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategory(category.getName());
        dto.setId(category.getId());
        return dto;
    }
}
