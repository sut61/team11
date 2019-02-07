package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Repairman;
import sut.se.team11.repository.RepairmanRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RepairmanController {
    @Autowired
    private RepairmanRepository repairmanRepository;


    @GetMapping(path = "/Repairmans")
    public List<Repairman> getRepairman(){
        return repairmanRepository.findAll().stream().collect(Collectors.toList());
    }
}
