package sut.se.team11.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Data
@NoArgsConstructor
public class Position {
    @Id
    @SequenceGenerator(name = "position_seq", sequenceName = "position_seq")
    @GeneratedValue(generator = "position_seq", strategy = GenerationType.SEQUENCE)
    private @NotNull  Long psId;
    private @NotNull  String psName;
}
