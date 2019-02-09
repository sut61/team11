package sut.se.team11.entity;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor

public class ScoreAssignment {
    @Id
    @SequenceGenerator(name = "scoreAssignment_seq", sequenceName = "scoreAssignment_seq")
    @GeneratedValue(generator = "scoreAssignment_seq", strategy = GenerationType.SEQUENCE)
    private @NotNull Long scoreAssignmentId;
    private @NotNull String level;

}
