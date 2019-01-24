package sut.se.team11.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Receipt {
    @Id
    @SequenceGenerator(name = "receipt_seq",sequenceName = "receipt_seq")
    @GeneratedValue(generator = "receipt_seq",strategy = GenerationType.SEQUENCE)
    private Long rId;
    private @NonNull Date date;
    private @NonNull double netPrice;

    @ManyToOne
    @JoinColumn(name = "branchId")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    public double sumTotalPrice() {
        BuyItem buyItem = new BuyItem();
        int itemAmount = cart.getBuyItems().size();
        for(int i = 0; i < itemAmount; i++){
            netPrice =+ buyItem.getTotalPrice();;
        }
        return netPrice ;
    }
}

