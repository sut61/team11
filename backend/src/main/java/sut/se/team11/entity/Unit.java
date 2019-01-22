package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Unit {
    @Id
    @SequenceGenerator(name = "unit_seq", sequenceName = "unit_seq")
    @GeneratedValue(generator = "unit_seq", strategy = GenerationType.SEQUENCE)
    private Long unitId;
    private @NonNull String unitName;
}
