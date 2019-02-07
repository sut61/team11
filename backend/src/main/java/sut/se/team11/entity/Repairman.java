package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Repairman {
    @Id
    @SequenceGenerator(name = "repairman_seq", sequenceName = "repairman_seq")
    @GeneratedValue(generator = "repairman_seq", strategy = GenerationType.SEQUENCE)
    private Long repairmanId;
    @NotNull
    private String repairmanName;
}
