package sut.se.team11.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import sut.se.team11.entity.Category;
import sut.se.team11.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    @Autowired private CategoryRepository categoryRepository;

    @GetMapping(path = "/getCategories")
    private List<Category> getCategories(){
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }
}
