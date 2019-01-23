package sut.se.team11.entity;

import lombok.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
public class SaleItem {
    @Id
    @SequenceGenerator(name = "sale_seq", sequenceName = "sale_seq")
    @GeneratedValue(generator = "sale_seq", strategy = GenerationType.SEQUENCE)
    private Long saleItemId;
    private @NonNull String itemName;
    private @NonNull double price;
    private @NonNull int amount;
    private @NonNull Date date;


    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "buyItemId")
    private BuyItem buyItem;

}
