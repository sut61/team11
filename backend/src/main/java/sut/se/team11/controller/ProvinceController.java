package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Province;
import sut.se.team11.repository.ProvinceRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


public class ProvinceController {
    @Autowired
    public ProvinceRepository provinceRepository ;

    @GetMapping("/Province")
    public List<Province> Province(){
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
}