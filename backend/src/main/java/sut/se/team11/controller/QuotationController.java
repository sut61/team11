package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Customer;
import sut.se.team11.entity.Quotation;
import sut.se.team11.entity.Employee;
import sut.se.team11.entity.Category;
import sut.se.team11.repository.CategoryRepository;
import sut.se.team11.repository.CustomerRepository;
import sut.se.team11.repository.EmployeeRepository;
import sut.se.team11.repository.QuotationRepository;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuotationController {
    @Autowired
    private QuotationRepository quotationRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/Quotation")
    public Collection<Quotation> Quotation(){
        return quotationRepository.findAll().stream().collect(Collectors.toList());

    }

    @PostMapping("/Quotation/{employeeId}/{customerId}/{categoryId}/{detail}/{price}")
    public Quotation quotation(@RequestBody Quotation quotation,
                               @PathVariable Double price,
                               @PathVariable String detail,
                               @PathVariable long customerId,
                               @PathVariable long employeeId,
                               @PathVariable long categoryId){

        Customer customer = customerRepository.findById(customerId);
        Employee employee = employeeRepository.findById(employeeId);
        Category  category =  categoryRepository.findById(categoryId);


        Quotation quotation1 = new Quotation();

        quotation1.setPrice(price);
        quotation1.setDetail(detail);
        quotation1.setDate(new Date());
        quotation1.setCustomer(customer);
        quotation1.setEmployee(employee);
        quotation1.setCategory(category);

        return  quotationRepository.save(quotation1);
    }

    @GetMapping("/Category")
    public Collection <Category> Category() {

        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }


}
