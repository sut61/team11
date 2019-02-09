package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.se.team11.entity.Branch;
import sut.se.team11.entity.Employee;
import sut.se.team11.entity.Promotion;
import sut.se.team11.entity.TypePromotion;
import sut.se.team11.repository.BranchRepository;
import sut.se.team11.repository.EmployeeRepository;
import sut.se.team11.repository.PromotionRepository;
import sut.se.team11.repository.TypePromotionRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionController {
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private TypePromotionRepository typePromotionRepository;



    @GetMapping("/Promotion")
    public  Collection<Promotion> promotions(){
        return promotionRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/Promotion/{eId}")
    public Promotion promotion(@RequestBody Promotion promotion,
                               @PathVariable long eId) {

        long bId = promotion.getBranch().getBId();
        long typePromotionId = promotion.getTypePromotion().getTypePromotionId();
        Employee employee = employeeRepository.findById(eId);
        Branch branch = branchRepository.findById(bId);
        TypePromotion typePromotion = typePromotionRepository.findById(typePromotionId);

        Promotion promotion1 = new Promotion();

        promotion1.setPromotionName(promotion.getPromotionName());
        promotion1.setNumberOfTime(promotion.getNumberOfTime());
        promotion1.setDetailPromotion(promotion.getDetailPromotion());
        promotion1.setDateIn(promotion.getDateIn());
        promotion1.setDateOut(promotion.getDateOut());
        promotion1.setEmployee(employee);
        promotion1.setBranch(branch);
        promotion1.setTypePromotion(typePromotion);

        return promotionRepository.save(promotion1);

    }

}
