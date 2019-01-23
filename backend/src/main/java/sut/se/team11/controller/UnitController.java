package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Unit;
import sut.se.team11.repository.UnitRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UnitController {
    @Autowired
    private UnitRepository unitRepository;

    @GetMapping(path = "/getUnits")
    private List<Unit> getAllUnits(){
        return unitRepository.findAll().stream().collect(Collectors.toList());
    }
}
