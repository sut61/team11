package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/Employee/{title}/{name}/{bdate}/{age}/{tel}/{address}/{pId}/{edId}/{bId}/{psId}")
    public Employee newEmployee(@RequestBody Employee newEmployee, @PathVariable String title, @PathVariable String name,
                                @PathVariable Date bdate, @PathVariable int age, @PathVariable String tel, @PathVariable String address,
                                @PathVariable long pId, @PathVariable long edId, @PathVariable long bId, @PathVariable long psId) {
        Province province = provinceRepository.findById(pId);
        Education education = educationRepository.findById(edId);
        Branch branch = branchRepository.findById(bId);
        Position position = positionRepository.findById(psId);

        newEmployee.setTitle(title);
        newEmployee.setEName(name);
//        newEmployee.setBDate(bdate);
        newEmployee.setAge(age);
        newEmployee.setTel(tel);
        newEmployee.setAddress(address);
        newEmployee.setProvince(province);
        newEmployee.setEducation(education);
        newEmployee.setBranch(branch);
        newEmployee.setPosition(position);

        return employeeRepository.save(newEmployee);
    }
}
