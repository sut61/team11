package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Stock {
    @Id
    @SequenceGenerator(name = "stock_seq", sequenceName = "stock_seq")
    @GeneratedValue(generator = "stock_seq", strategy = GenerationType.SEQUENCE)
    private Long stockId;
    @NotNull
    private String stockName;
    private String description;

}