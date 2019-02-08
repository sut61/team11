package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@NoArgsConstructor
public class TypePromotion {
    @Id
    @SequenceGenerator(name = "typePromotion_seq", sequenceName = "typePromotion_seq")
    @GeneratedValue(generator = "typePromotion_seq", strategy = GenerationType.SEQUENCE)
    private @NotNull Long typePromotionId;
    private @NotNull String typePromotionName;

}
