package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor

public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quotationidId;
    private @NonNull double price;
    private @NonNull String detail;
    private @NonNull Date date;



    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee employee ;


    @ManyToOne
    @JoinColumn(name = "BuyItemId")
    private BuyItem buyItem;


}
