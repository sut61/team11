package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.BuyItem;
import sut.se.team11.entity.Customer;
import sut.se.team11.entity.Employee;
import sut.se.team11.entity.SaleItem;
import sut.se.team11.repository.BuyItemRepository;
import sut.se.team11.repository.CustomerRepository;
import sut.se.team11.repository.EmployeeRepository;
import sut.se.team11.repository.SaleItemRepository;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SaleItemController {
    @Autowired
    private SaleItemRepository saleItemRepository;
    @Autowired
    private EmployeeRepository employeeRepository ;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BuyItemRepository buyItemRepository;

//    @GetMapping(path = "/SaleItem")
//    public Collection<SaleItem> SaleItem() {
//        return saleItemRepository.findAll().stream().collect(Collectors.toList());
//    }

    @PostMapping(path = "/{customerId}/{eId}/{buyItemId}/newSaleItem")
    private ResponseEntity<SaleItem> newSaleItem(@RequestBody SaleItem saleItem, @PathVariable long customerId, @PathVariable long eId,
                                                 @PathVariable long buyItemId){

        SaleItem s = new SaleItem();

//        Customer customer1 = customerRepository.findById(customerId);
//        if(customer1 == null){
//            return ResponseEntity.notFound().build();
//        }

//        long customerId = saleItem.getCustomer().getCustomerId();
//        long eId = saleItem.getEmployee().getEId();

        double totalPrice = s.calTotalPrice(saleItem.getPrice(), saleItem.getAmount());

        Employee employee = employeeRepository.findById(eId);
        BuyItem buyItem = buyItemRepository.findById(buyItemId);
        Customer customer = customerRepository.findById(customerId);

        if(customer  != null && employee != null && buyItem != null) {

            s.setItemName(saleItem.getItemName());
            s.setPrice(saleItem.getPrice());
            s.setAmount(saleItem.getAmount());
            s.setDate(new Date());
            s.setBuyItem(buyItem);
            s.setCustomer(customer);
            s.setEmployee(employee);
            s.setTotalPrice(totalPrice);

            SaleItem saleItem1 = saleItemRepository.save(s);
            return ResponseEntity.ok().body(saleItem1);
        }
        return ResponseEntity.notFound().build();
    }

//    @GetMapping(path = "/findSaleItem/{saleItemId}")
//    private ResponseEntity<SaleItem> findSaleItem(@PathVariable long saleItemId){
//        System.out.println(saleItemId);
//        SaleItem s = saleItemRepository.findById(saleItemId);
//        if(s == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(s);
//    }

}
