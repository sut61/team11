package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Unit;
import sut.se.team11.repository.UnitRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UnitController {
    @Autowired
    private UnitRepository unitRepository;

    @GetMapping(path = "/getUnits")
    private List<Unit> getAllUnits(){
        return unitRepository.findAll().stream().collect(Collectors.toList());
    }
}
