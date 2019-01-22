package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class BuyItem {
    @Id
    @GeneratedValue
    private Long butItemId;
    private @NonNull String itemName;
    private @NonNull double price;
    private @NonNull int amount;
    private @NonNull double totalPrice;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "unitId")
    private Unit unit;
}
