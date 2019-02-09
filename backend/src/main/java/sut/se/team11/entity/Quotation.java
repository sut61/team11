package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor

public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quotationidId;


    @NotNull
    @Min(0)
    @Max(1000000)
    @NumberFormat(pattern = "#,###,###.##")
    private double price;


    @NotNull
    private String detail;

    @NotNull
    private  Date date;



    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee employee ;


    @ManyToOne
    @JoinColumn(name = "Category")
    private Category category;


}
