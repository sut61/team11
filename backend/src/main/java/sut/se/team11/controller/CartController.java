package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.Cart;
import sut.se.team11.entity.Customer;
import sut.se.team11.repository.CartRepository;
import sut.se.team11.repository.CustomerRepository;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;

    @PostMapping(path = "/{customerId}/newCart")
    private ResponseEntity<Cart> newCart(@PathVariable long customerId, @RequestBody Cart cart) {
        Cart c = new Cart();
        Customer customer = customerRepository.findById(customerId);

        if(customer == null){
            return ResponseEntity.notFound().build();
        }

        c.setDate(new Date());
        c.setPaymentStatus(cart.getPaymentStatus());
        c.setCustomer(customer);

        Cart cSave = cartRepository.save(c);
        return ResponseEntity.ok().body(cSave);
    }

    @GetMapping(path = "/getCart/{cartId}")
    private ResponseEntity<Cart> findCart(@PathVariable long cartId){
        Cart cart = cartRepository.findById(cartId);
        if(cart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cart);
    }
}
