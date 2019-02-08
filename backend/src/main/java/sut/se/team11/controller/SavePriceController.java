package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Category;
import sut.se.team11.entity.Employee;
import sut.se.team11.entity.SavePrice;
import sut.se.team11.entity.UsedItem;
import sut.se.team11.repository.CategoryRepository;
import sut.se.team11.repository.EmployeeRepository;
import sut.se.team11.repository.SavePriceRepository;
import sut.se.team11.repository.UsedItemRepository;

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

    @PostMapping(path = "/newPriceTag")
    private SavePrice newPriceTag(@RequestBody SavePrice savePrice) {
        SavePrice sp = new SavePrice();
        long C1 = savePrice.getCategoryOne().getCategoryId();
        long C2 = savePrice.getCategoryTwo().getCategoryId();
        long used = savePrice.getUsedItem().getUsedItemId();

        Category c1 = categoryRepository.findById(C1);
        Category c2 = categoryRepository.findById(C2);
        UsedItem ut = usedItemRepository.findById(used);
        Employee em = employeeRepository.findById(savePrice.getEmployee().getEId());

        sp.setCategoryOne(c1);
        sp.setPriceOne(savePrice.getPriceOne());
        sp.setCategoryTwo(c2);
        sp.setPriceTwo(savePrice.getPriceTwo());
        sp.setUsedItem(ut);
        sp.setExplain(savePrice.getExplain());
        sp.setEmployee(em);

        return savePriceRepository.save(sp);
    }
}
