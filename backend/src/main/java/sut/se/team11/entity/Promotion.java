package sut.se.team11.entity;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor


public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long promotionId;

    private @NotNull String promotionName;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    @Positive
    private Integer numberOfTime;

    private @NotNull String detailPromotion;
    private @NotNull Date dateIn;
    private @NotNull Date dateOut;


    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "BranchId")
    private Branch branch;


    @ManyToOne
    @JoinColumn(name = "TypePromotionId")
    private TypePromotion typePromotion;



}

