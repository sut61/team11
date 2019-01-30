package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.*;
import sut.se.team11.repository.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


class EmployeeController {
    @Autowired
    public EmployeeRepository employeeRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private EducationRepository educationRepository;

    @GetMapping("/Employee")
    public Collection<Employee> Employee() {

        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path = "/newEmp")
    private Employee newEmp(@RequestBody Employee employee){
        Employee e = new Employee();
        long ps = employee.getPosition().getPsId();
        long p = employee.getProvince().getPId();
        long ed = employee.getEducation().getEdId();
        long b = employee.getBranch().getBId();

        Position ps1 = positionRepository.findById(ps);
        Province p1 = provinceRepository.findById(p);
        Education e1 = educationRepository.findById(ed);
        Branch br = branchRepository.findById(b);

        e.setBDate(employee.getBDate());
        e.setEducation(e1);
        e.setPosition(ps1);
        e.setBranch(br);
        e.setProvince(p1);
        e.setTel(employee.getTel());
        e.setAddress(employee.getAddress());
        e.setAge(employee.getAge());
        e.setEName(employee.getEName());
        e.setTitle(employee.getTitle());

        return employeeRepository.save(e);
    }
    @GetMapping(path = "/findEmployee/{eId}")
    private ResponseEntity<Employee> findEmployee(@PathVariable long eId){
        System.out.println(eId);
        Employee employee = employeeRepository.findById(eId);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }
}
