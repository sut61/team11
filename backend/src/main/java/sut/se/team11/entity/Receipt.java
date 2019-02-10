package sut.se.team11.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Receipt {
    @Id
    @SequenceGenerator(name = "receipt_seq",sequenceName = "receipt_seq")
    @GeneratedValue(generator = "receipt_seq",strategy = GenerationType.SEQUENCE)
    private Long rId;
    private  Date date;

    @Negative
    @NegativeOrZero
    @Min(value = 10)
    @Max(value = 100000)
    private  double netPrice;

    @ManyToOne
    @JoinColumn(name = "branchId")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;









}

