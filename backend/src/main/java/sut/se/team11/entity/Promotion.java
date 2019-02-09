package sut.se.team11.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor


public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long promotionId;
    private @NonNull String promotionName;
    private @NonNull Integer numberOfTime;
    private @NonNull String detailPromotion;
    private @NonNull Date dateIn;
    private @NonNull Date dateOut;


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

