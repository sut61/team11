package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.ProblemType;
import sut.se.team11.repository.ProblemTypeRepository;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ProblemTypeController {

    @Autowired
    private ProblemTypeRepository problemTypeRepository;

    @GetMapping("/ProblemType")
    public List<ProblemType> problemTypes(){
        return problemTypeRepository.findAll().stream().collect(Collectors.toList());
    }
}
