package sut.se.team11.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Entity

public class Assignment {
    @Id
    @SequenceGenerator(name = "assignment_seq", sequenceName = "assignment_seq")
    @GeneratedValue(generator = "assignment_seq", strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private Long assignmentId;


    @Size(min = 5, max = 15)
    @Pattern(regexp = "\\w+")
    private @NotNull String comment;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @OneToOne
    @NotNull
    @JoinColumn(name = "scoreAssignmentId")
    private ScoreAssignment scoreAssignment;

    public Assignment (){

    }

}
