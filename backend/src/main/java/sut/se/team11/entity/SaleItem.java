package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
public class SaleItem {
    @Id
    @SequenceGenerator(name = "sale_seq", sequenceName = "sale_seq")
    @GeneratedValue(generator = "sale_seq", strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private @NotNull Long saleItemId;
    @Min(0)
    @Max(1000000)
    @NumberFormat(pattern = "#,###,###.##")
    private @NotNull double price;
    private @NotNull int amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private @NotNull Date date;
    private @NotNull double totalPrice;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @NotNull
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
