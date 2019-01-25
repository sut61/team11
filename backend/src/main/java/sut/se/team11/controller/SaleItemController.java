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

    @GetMapping(path = "/SaleItem")
    public Collection<SaleItem> SaleItem() {
        return saleItemRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/SaleItem/{itemName}/{price}/{amount}/{date}")
    public SaleItem newSaleItem(@RequestBody SaleItem saleItem, @PathVariable String itemName,
                                @PathVariable double price, @PathVariable int amount,
                                @PathVariable Date date,@PathVariable long customerid,
                                @PathVariable long eId,@PathVariable long buyItemId){

        SaleItem saleItem1 = new SaleItem();

        double totalPrice = saleItem1.calTotalPrice(saleItem.getPrice(), saleItem.getAmount());

        Employee employee = employeeRepository.findById(eId);
        BuyItem buyItem = buyItemRepository.findById(buyItemId);
        Customer customer = customerRepository.findById(customerid);

        saleItem1.setItemName(itemName);
        saleItem1.setPrice(price);
        saleItem1.setAmount(amount);
        saleItem1.setDate(date);
        saleItem1.setBuyItem(buyItem);
        saleItem1.setCustomer(customer);
        saleItem1.setEmployee(employee);
        saleItem1.setTotalPrice(totalPrice);

        return saleItemRepository.save(saleItem1);
    }

    @GetMapping(path = "/findSaleItem/{saleItemId}")
    private ResponseEntity<SaleItem> findSaleItem(@PathVariable long saleItemId){
        SaleItem s = saleItemRepository.findById(saleItemId);
        if(s == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(s);
    }

}
