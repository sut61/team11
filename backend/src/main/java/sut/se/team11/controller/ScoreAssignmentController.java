package sut.se.team11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.ScoreAssignment;
import sut.se.team11.repository.ScoreAssignmentReposistory;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ScoreAssignmentController {
    @Autowired
    public ScoreAssignmentReposistory scoreAssignmentRepository;

    @GetMapping("/ScoreAssignment")
    public List<ScoreAssignment> scoreAssignment(){
        return scoreAssignmentRepository.findAll().stream().collect(Collectors.toList());
    }
}
