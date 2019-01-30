package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private @NonNull Date date;
    private @NonNull double totalPrice;


    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "buyItemId")
    private BuyItem buyItem;

    public double calTotalPrice(double price, int amount){
        return price * amount;
    }


}
