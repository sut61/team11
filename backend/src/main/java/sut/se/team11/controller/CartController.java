package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Cart;
import sut.se.team11.entity.Customer;
import sut.se.team11.repository.CartRepository;
import sut.se.team11.repository.CustomerRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class CartController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;

    @PostMapping(path = "/{customerId}/newCart")
    private ResponseEntity<Cart> newCart(@PathVariable long customerId, @RequestBody Cart cart)throws ParseException {
        Cart c = new Cart();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String toParse = sdf.format(date);
        System.out.println(toParse);
        Date d = sdf.parse(toParse);

        Customer customer = customerRepository.findById(customerId);

        if(customer == null){
            return ResponseEntity.notFound().build();
        }

        c.setDate(d);
        c.setPaymentStatus(cart.getPaymentStatus());
        c.setCustomer(customer);

        Cart cSave = cartRepository.save(c);

        return ResponseEntity.ok().body(cSave);
    }
}
