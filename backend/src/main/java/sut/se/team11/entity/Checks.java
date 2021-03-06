package sut.se.team11.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Checks {
    @Id
    @SequenceGenerator(name = "checks_seq", sequenceName = "checks_seq")
    @GeneratedValue(generator = "checks_seq", strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private @NotNull Long checksId;

    @Size(min = 5, max = 50)
    @Pattern(regexp = "\\w+")
    private @NotNull String evaluate;
    private @NotNull Date date;
    @Min(1)
    private  @NotNull int weight;

    @ManyToOne
    private @NotNull Employee employee;
    @ManyToOne
    private @NotNull BuyItem buyItem;
    @ManyToOne
    private @NotNull  Categorize categorize;


    @OneToOne(mappedBy = "checks", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UsedItem usedItem;
    public Checks() {

    }
}

