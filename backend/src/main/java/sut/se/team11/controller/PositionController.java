package sut.se.team11.controller;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Education;
import sut.se.team11.entity.Position;
import sut.se.team11.repository.PositionRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PositionController {
    @Autowired
    public PositionRepository positionRepository;

    @GetMapping("/Position")
    public List<Position> Position() {
        return positionRepository.findAll().
                stream().collect(Collectors.toList());
    }
}