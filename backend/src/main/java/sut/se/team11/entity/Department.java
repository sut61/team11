package sut.se.team11.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Department {
    @Id
    @SequenceGenerator(name = "department_seq", sequenceName = "department_seq")
    @GeneratedValue(generator = "department_seq", strategy = GenerationType.SEQUENCE)
    private Long depId;
    private String depName;
}
