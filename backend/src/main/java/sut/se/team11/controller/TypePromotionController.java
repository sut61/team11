package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.TypePromotion;
import sut.se.team11.repository.TypePromotionRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class TypePromotionController {
    @Autowired
    public TypePromotionRepository typePromotionRepository;

    @GetMapping("/TypePromotion")
    public List<TypePromotion> TypePromotion(){
        return typePromotionRepository.findAll().stream().collect(Collectors.toList());
    }
}
