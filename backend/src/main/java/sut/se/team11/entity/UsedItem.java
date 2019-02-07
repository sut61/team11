package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class UsedItem {
    @Id
    @SequenceGenerator(name = "used_seq", sequenceName = "used_seq")
    @GeneratedValue(generator = "used_seq", strategy = GenerationType.SEQUENCE)
    private Long usedItemId;
    @NotNull
    private double price;
    @NotNull
    private String details;
}
