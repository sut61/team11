package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Department;
import sut.se.team11.repository.DepartmentRepository;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/Department")
    public List<Department> dapartment(){
        return departmentRepository.findAll().stream().collect(Collectors.toList());
    }

}
