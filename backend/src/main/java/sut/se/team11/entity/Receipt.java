package sut.se.team11.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Receipt {
    @Id
    @SequenceGenerator(name = "receipt_seq",sequenceName = "receipt_seq")
    @GeneratedValue(generator = "receipt_seq",strategy = GenerationType.SEQUENCE)
    private Long rId;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private  Date date;

    @Positive
    @Min(value = 1)
    private  double netPrice;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "branchId")
    private Branch branch;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @NotNull
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;









}

