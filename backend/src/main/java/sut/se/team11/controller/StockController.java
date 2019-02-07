package sut.se.team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.se.team11.entity.Stock;
import sut.se.team11.repository.StockRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @GetMapping(path = "/Stocks")
    private List<Stock> getStocks(){
        return stockRepository.findAll().stream().collect(Collectors.toList());
    }
}
