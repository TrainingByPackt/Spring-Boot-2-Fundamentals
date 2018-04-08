package com.packt.springboot.blogmania.category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category Category);

    Optional<Category> findCategoryBySlug(String slug);

    List<Category> findAll();
}
