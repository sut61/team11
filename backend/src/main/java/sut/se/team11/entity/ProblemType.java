package sut.se.team11.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class ProblemType {
    @Id
    @SequenceGenerator(name = "problem_type_seq", sequenceName = "problem_type_seq")
    @GeneratedValue(generator = "problem_type_seq", strategy = GenerationType.SEQUENCE)
    private Long ptId;
    private String ptName;
}
