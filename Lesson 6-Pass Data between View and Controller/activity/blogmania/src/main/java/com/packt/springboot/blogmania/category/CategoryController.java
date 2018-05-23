package com.packt.springboot.blogmania.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    // STEP 5
    // Add a field called allCategories of type ArrayList<Category> that will hold all available categories.
    // Don’t forget to initialize the list.

    // STEP 6
    // Add a method renderCategoryForm() to initialize a new empty category and add it to the model as an attribute
    // named category. This method should be mapped to the get request with the URI “/categories/new”.
    // Render a view named “/categories/form”.

    // STEP 7
    // Add a method addCategory() with a post request mapping for “/categories”. This method will receive a Category as a
    // parameter and add it to the list of all categories. Return “redirect:/” as the view name.

    // STEP 8
    // Implement the currently empty method retrieveAllCategories() to return the list of all categories.
    // You may want to return a copy of the list to prevent clients from changing the original list.
    public List<Category> retrieveAllCategories() {
        return null;
    }
}
