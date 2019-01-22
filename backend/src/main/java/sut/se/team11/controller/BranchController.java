package sut.se.team11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Branch;
import sut.se.team11.repository.BranchRepository;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class BranchController {
    @Autowired
    public BranchRepository branchRepository ;

    @GetMapping("/Branch")
    public List<Branch> Branch(){
        return branchRepository.findAll().stream().collect(Collectors.toList());
    }
}