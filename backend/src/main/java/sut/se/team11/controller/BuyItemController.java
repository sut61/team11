package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.BuyItem;
import sut.se.team11.entity.Cart;
import sut.se.team11.entity.Category;
import sut.se.team11.entity.Unit;
import sut.se.team11.repository.BuyItemRepository;
import sut.se.team11.repository.CartRepository;
import sut.se.team11.repository.CategoryRepository;
import sut.se.team11.repository.UnitRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BuyItemController {
    @Autowired
    private BuyItemRepository buyItemRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping(path = "/{cartId}/newItem")
    private ResponseEntity<BuyItem> newBuyItem(@PathVariable long cartId, @RequestBody BuyItem buyItem){

        BuyItem b = new BuyItem();

        long categoryId = buyItem.getCategory().getCategoryId();
        long unitId = buyItem.getUnit().getUnitId();
        double totalPrice = b.calTotalPrice(buyItem.getPrice(), buyItem.getAmount());

        Category category = categoryRepository.findById(categoryId);
        Unit unit = unitRepository.findById(unitId);
        Cart cart = cartRepository.findById(cartId);

        if(category  != null && unit != null && cart != null){
            b.setItemName(buyItem.getItemName());
            b.setPrice(buyItem.getPrice());
            b.setAmount(buyItem.getAmount());
            b.setTotalPrice(totalPrice);
            b.setCart(cart);
            b.setCategory(category);
            b.setUnit(unit);

            BuyItem buyItem1 = buyItemRepository.save(b);
            return ResponseEntity.ok().body(buyItem1);
        }
        return ResponseEntity.notFound().build();
    }
}
