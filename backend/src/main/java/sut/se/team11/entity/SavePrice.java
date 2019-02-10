package sut.se.team11.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
@NoArgsConstructor
public class SavePrice {
    @Id
    @SequenceGenerator(name = "price_seq", sequenceName = "price_seq")
    @GeneratedValue(generator = "price_seq", strategy = GenerationType.SEQUENCE)
    private long priceTagId;
    @ManyToOne
    private Category categoryOne;
    @Positive
    @Min(0)
    @Max(10000)
    private int priceOne;
    @ManyToOne
    private Category categoryTwo;
    @Positive
    @Min(0)
    @Max(10000)
    private int priceTwo;
    @ManyToOne
    private UsedItem usedItem;
    @ManyToOne
    private Employee employee;
}
