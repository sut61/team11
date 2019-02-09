package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.Category;
import sut.se.team11.entity.Employee;
import sut.se.team11.entity.SavePrice;
import sut.se.team11.entity.UsedItem;
import sut.se.team11.repository.CategoryRepository;
import sut.se.team11.repository.EmployeeRepository;
import sut.se.team11.repository.SavePriceRepository;
import sut.se.team11.repository.UsedItemRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SavePriceController {
    @Autowired
    private SavePriceRepository savePriceRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UsedItemRepository usedItemRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/SavePrice")
    public Collection<SavePrice> SavePrice() {

        return savePriceRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/newSavePrice/{c1}/{c2}")
    private SavePrice newSavePrice (@RequestBody SavePrice savePrice,@PathVariable long c1,@PathVariable long c2) {
        SavePrice sp = new SavePrice();
        long used = savePrice.getUsedItem().getUsedItemId();


        Category category1 = categoryRepository.findById(c1);
        Category category2 = categoryRepository.findById(c2);
        UsedItem ut = usedItemRepository.findById(used);
        Employee em = employeeRepository.findById(savePrice.getEmployee().getEId());

        sp.setCategoryOne(category1);
        sp.setPriceOne(savePrice.getPriceOne());
        sp.setCategoryTwo(category2);
        sp.setPriceTwo(savePrice.getPriceTwo());
        sp.setUsedItem(ut);
        sp.setUsedItem(ut);
        sp.setEmployee(em);


        return savePriceRepository.save(sp);
    }
}
