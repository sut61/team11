package sut.se.team11.entity;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity

public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    @GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private @NotNull Long customerId;
    private @NotNull String customerName;
    private @NotNull String address;
    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "\\d+")
    private  String tel;

    @ManyToOne
    private @NotNull Branch branch;

    @ManyToOne
    private @NotNull Career career;

    @ManyToOne
    private @NotNull Province province;


    public Customer() {}

}
