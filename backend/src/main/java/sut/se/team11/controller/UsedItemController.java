package sut.se.team11.controller;

import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.Checks;
import sut.se.team11.entity.Repairman;
import sut.se.team11.entity.Stock;
import sut.se.team11.entity.UsedItem;
import sut.se.team11.repository.ChecksRepository;
import sut.se.team11.repository.RepairmanRepository;
import sut.se.team11.repository.StockRepository;
import sut.se.team11.repository.UsedItemRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsedItemController {
    @Autowired
    private UsedItemRepository usedItemRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ChecksRepository checksRepository;
    @Autowired
    private RepairmanRepository repairmanRepository;

    @PostMapping(path = "/{checksId}/newUsedItem")
    private ResponseEntity<UsedItem> newUsedItem(@PathVariable long checksId, @RequestBody UsedItem usedItem){
        UsedItem u = new UsedItem();
        long repairmanId = usedItem.getRepairman().getRepairmanId();
        long stockId = usedItem.getStock().getStockId();

        Stock s = stockRepository.findById(stockId);
        Repairman r = repairmanRepository.findById(repairmanId);
        Checks c = checksRepository.findById(checksId);

        if(s == null && r == null && c == null){
            return ResponseEntity.notFound().build();
        }

        u.setPrice(usedItem.getPrice());
        u.setDetails(usedItem.getDetails());
        u.setStock(s);
        u.setChecks(c);
        u.setRepairman(r);
        UsedItem save = usedItemRepository.save(u);
        return ResponseEntity.ok().body(save);

    }

    @GetMapping(path = "/findChecks/{checksId}")
    private ResponseEntity<Checks> findChecks(@PathVariable long checksId){
        Checks c = checksRepository.findById(checksId);
        if(c == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(c);
    }
}
