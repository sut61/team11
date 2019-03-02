package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
public class BuyItem {
    @Id
    @SequenceGenerator(name = "buy_seq", sequenceName = "buy_seq")
    @GeneratedValue(generator = "buy_seq", strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private @NotNull Long buyItemId;
    @Size(min = 5, max = 15)
    @Pattern(regexp = "^[A-Za-z_ ]+")
    private @NotNull String itemName;
    @Min(50)
    private @NotNull double price;
    @Min(1)
    private @NotNull int amount;
    private @NotNull double totalPrice;

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
