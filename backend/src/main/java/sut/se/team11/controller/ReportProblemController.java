package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.Department;
import sut.se.team11.entity.Employee;
import sut.se.team11.entity.ProblemType;
import sut.se.team11.entity.ReportProblem;
import sut.se.team11.repository.DepartmentRepository;
import sut.se.team11.repository.EmployeeRepository;
import sut.se.team11.repository.ProblemTypeRepository;
import sut.se.team11.repository.ReportProblemRepository;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ReportProblemController {

    @Autowired
    private ReportProblemRepository reportProblemRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProblemTypeRepository problemTypeRepository;
	
    @GetMapping(path = "/reportProblem")
    private Collection<ReportProblem> reportProblem() {
	    return reportProblemRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/rpFindEmployee/{eId}")
    private ResponseEntity<Employee> findEmployee(@PathVariable long eId){
        Employee employee = employeeRepository.findById(eId);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping(path = "/newReport/{ptId}/{eId}/{depId}/{rpDetail}")
    public ReportProblem newReportProblem(  @RequestBody ReportProblem reportProblem,
                                            @PathVariable String rpDetail,
                                            @PathVariable long ptId,
                                            @PathVariable long eId,
                                            @PathVariable long depId
                                            ){
        ReportProblem rp = new ReportProblem();
        Department department = departmentRepository.findById(depId);
        ProblemType problemType = problemTypeRepository.findById(ptId);
        Employee employee = employeeRepository.findById(eId);

        rp.setProblemType(problemType);
        rp.setDepartment(department);
        rp.setEmployee(employee);
        rp.setDate(new Date());
        rp.setRpDetail(rpDetail);

        return reportProblemRepository.save(rp);
    }
}
