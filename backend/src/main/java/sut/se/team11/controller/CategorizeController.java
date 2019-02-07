package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sut.se.team11.entity.Categorize;
import sut.se.team11.repository.CategorizeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategorizeController {
    @Autowired
    public CategorizeRepository categorizeRepository;

    @GetMapping("/Categorize")
    public List<Categorize> Categorize(){
        return categorizeRepository.findAll().stream().collect(Collectors.toList());
    }
}
