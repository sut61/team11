package sut.se.team11.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import sut.se.team11.entity.Branch;
import sut.se.team11.entity.Career;
import sut.se.team11.entity.Customer;
import sut.se.team11.entity.Province;
import sut.se.team11.repository.*;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BranchRepository branchRepository ;
    @Autowired
    private CareerRepository careerRepository ;
    @Autowired
    private ProvinceRepository provinceRepository ;



    @GetMapping("/Customer")
    public Collection <Customer> Customer() {

        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Customer/{bId}/{name}/{tel}/{cId}/{address}/{pId}")
    public Customer newCustomer(@RequestBody Customer newCustomer,@PathVariable String name,@PathVariable String tel,@PathVariable String address,@PathVariable long bId,@PathVariable long pId,@PathVariable long cId) {


        Branch branch = branchRepository.findById(bId);
        Career career = careerRepository.findById(cId);
        Province province = provinceRepository.findById(pId);

        newCustomer.setCustomerName(name);
        newCustomer.setTel(tel);
        newCustomer.setAddress(address);
        newCustomer.setBranch(branch);
        newCustomer.setCareer(career);
        newCustomer.setProvince(province);


        return  customerRepository.save(newCustomer);
    }


    //B5804658
    @GetMapping(path = "/findCustomer/{customerId}")
    private ResponseEntity<Customer> findCustomer(@PathVariable long customerId){
        Customer c = customerRepository.findById(customerId);
        if(c == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(c);
    }

}
