package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.*;
import sut.se.team11.repository.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ReceiptController {
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BuyItemRepository buyItemRepository;

    @PostMapping(path = "/newReceipt/{netPrice}")
    public Receipt newReceipt(@RequestBody Receipt receipt,
                              @PathVariable long eId,
                              @PathVariable long bId,
                              @PathVariable long cartId){
        Receipt newReceipt = new Receipt();

        Branch branch = branchRepository.findById(bId);
        Employee employee = employeeRepository.findById(eId);
        Cart cart = cartRepository.findById(cartId);

        newReceipt.setBranch(branch);
        newReceipt.setCart(cart);
        newReceipt.setEmployee(employee);
        newReceipt.setDate(new Date()); //??
        double netPrice = newReceipt.sumTotalPrice();
        newReceipt.setNetPrice(netPrice);

        return receiptRepository.save(receipt);
    }

    @PutMapping(path ="/reUpdate/{cartId}")
    public void updatePayment(@PathVariable long cartId) {
        Cart updateStatus = cartRepository.findById(cartId);
        updateStatus.setPaymentStatus("Success");
        cartRepository.save(updateStatus);
    }

    @GetMapping("/receipt")
    public Collection<Receipt> receipts() {
        return receiptRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/reFindEmployee/{eId}")
    private ResponseEntity<Employee> findEmployee(@PathVariable long eId){
        Employee employee = employeeRepository.findById(eId);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping(path = "/reFindCart/{cartId}")
    private ResponseEntity<Cart> findCart(@PathVariable long cartId){
        Cart cart = cartRepository.findById(cartId);
        if(cart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cart);
    }
}
