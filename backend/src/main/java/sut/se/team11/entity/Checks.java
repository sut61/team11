package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Checks {
    @Id
    @SequenceGenerator(name = "checks_seq", sequenceName = "checks_seq")
    @GeneratedValue(generator = "checks_seq", strategy = GenerationType.SEQUENCE)
    private Long checksId;

    private @NotNull String evaluate;
    private Date date;


    @NotNull
    @Size(min = 2, max = 5)
    @Pattern(regexp = "\\d+")
    private String weight;

    @ManyToOne
    private  Employee employee;
    @ManyToOne
    private BuyItem buyItem;
    @ManyToOne
    private Categorize categorize;


    @OneToOne(mappedBy = "checks", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UsedItem usedItem;
}
