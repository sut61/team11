package sut.se.team11.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import sut.se.team11.entity.*;
import sut.se.team11.repository.*;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class ChecksController {
    @Autowired
    private ChecksRepository checksRepository;
    @Autowired
    private EmployeeRepository employeeRepository ;
    @Autowired
    private CategorizeRepository categorizeRepository ;
    @Autowired
    private BuyItemRepository buyItemRepository ;



    @GetMapping("/Checks")
    public Collection <Checks> Checks() {
        return checksRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/Checks/{eId}/{buyItemId}/{evaluate}/{weight}/{categorizeId}")
    public Checks newCheck(@RequestBody Checks newCheck,@PathVariable String evaluate,@PathVariable String weight,
                           @PathVariable long eId,@PathVariable long categorizeId,@PathVariable long buyItemId){

        Categorize categorize = categorizeRepository.findById(categorizeId);
        Employee employee = employeeRepository.findById(eId);
        BuyItem buyItem = buyItemRepository.findById(buyItemId);

        newCheck.setEvaluate(evaluate);
        newCheck.setWeight(weight);
        newCheck.setBuyItem(buyItem);
        newCheck.setEmployee(employee);
        newCheck.setCategorize(categorize);

        return checksRepository.save(newCheck);

    }

    @GetMapping(path = "/checkEmployee/{eId}")
    private ResponseEntity<Employee> checkEmployee(@PathVariable long eId){
        Employee employee = employeeRepository.findById(eId);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }


}
