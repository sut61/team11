package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class BuyItem {
    @Id
    @SequenceGenerator(name = "buy_seq", sequenceName = "buy_seq")
    @GeneratedValue(generator = "buy_seq", strategy = GenerationType.SEQUENCE)
    private Long buyItemId;
    private @NonNull String itemName;
    private @NonNull double price;
    private @NonNull int amount;
    private @NonNull double totalPrice;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "unitId")
    private Unit unit;

    public double calTotalPrice(double price, int amount){
        return price * amount;
    }
}
