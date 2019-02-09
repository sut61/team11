package sut.se.team11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.*;
import sut.se.team11.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AssignmentController {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ScoreAssignmentReposistory scoreAssignmentRepository;

    @GetMapping("/Assignment")
    public Collection<Assignment> Assignment() {

        return assignmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/Assignment/{customerId}")
    private Assignment assignment(@RequestBody Assignment assignment, @PathVariable long customerId){

        Assignment a = new Assignment();
        long scoreAssignmentId = assignment.getScoreAssignment().getScoreAssignmentId();
        long eId = assignment.getEmployee().getEId();

        Employee employee = employeeRepository.findById(eId);
        Customer customer = customerRepository.findById(customerId);
        ScoreAssignment scoreAssignment = scoreAssignmentRepository.findById(scoreAssignmentId);

        a.setEmployee(employee);
        a.setCustomer(customer);
        a.setComment(assignment.getComment());
        a.setScoreAssignment(scoreAssignment);

        return assignmentRepository.save(a);
    }

}
