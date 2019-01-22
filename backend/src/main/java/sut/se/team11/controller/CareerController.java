package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Career;
import sut.se.team11.repository.CareerRepository;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CareerController {
    @Autowired
    public CareerRepository careerRepository ;

    @GetMapping("/Career")
    public List<Career> Career(){
        return careerRepository.findAll().stream().collect(Collectors.toList());
    }
}