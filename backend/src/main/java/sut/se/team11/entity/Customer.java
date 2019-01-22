package sut.se.team11.entity;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    @GeneratedValue(generator = "customer_seq", strategy = GenerationType.SEQUENCE)
    private Long customerId;
    private @NonNull String customerName;
    private @NonNull String address;
    private @NonNull String tel;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Career career;

    @ManyToOne
    private Province province;


    public Customer() {}

}
