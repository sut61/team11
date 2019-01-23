package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Education;
import sut.se.team11.repository.EducationRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin (origins = "http://localhost:4200")

public class EducationController {
    @Autowired
    public EducationRepository educationRepository;

    @GetMapping ("/Education")
    public List<Education> Education() {
        return educationRepository.findAll().stream()
                .collect(Collectors
                        .toList());
    }
}
