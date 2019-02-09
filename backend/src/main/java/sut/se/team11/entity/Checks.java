package sut.se.team11.entity;

import lombok.Data;

import javax.persistence.*;
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
    private @NotNull Long checksId;

    @Size(min = 5, max = 50)
    @Pattern(regexp = "\\w+")
    private @NotNull String evaluate;
    private Date date;

    private  @NotNull int weight;

    @ManyToOne
    private   Employee employee;
    @ManyToOne
    private BuyItem buyItem;
    @ManyToOne
    private Categorize categorize;


    @OneToOne(mappedBy = "checks", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UsedItem usedItem;
    public Checks() {

    }
}

