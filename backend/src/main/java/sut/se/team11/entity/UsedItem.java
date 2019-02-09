package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "stockId")
    private Stock stock;
    @ManyToOne
    @JoinColumn(name = "repairmanId")
    private Repairman repairman;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "checksId")
    @JsonIgnore
    private Checks checks;

}
