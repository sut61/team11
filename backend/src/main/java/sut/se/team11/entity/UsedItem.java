package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@NoArgsConstructor
public class UsedItem {
    @Id
    @SequenceGenerator(name = "used_seq", sequenceName = "used_seq")
    @GeneratedValue(generator = "used_seq", strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private Long usedItemId;
    @NotNull
    @Min(100)
    private double price;
    @NotNull
    @Size(min = 10, max = 50)
    @Pattern(regexp = "^[A-Za-z_ ]+")
    private String details;

    @ManyToOne
    @JoinColumn(name = "stockId")
    private @NotNull Stock stock;
    @ManyToOne
    @JoinColumn(name = "repairmanId")
    private @NotNull Repairman repairman;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "checksId")
    @JsonIgnore
    private Checks checks;

}
