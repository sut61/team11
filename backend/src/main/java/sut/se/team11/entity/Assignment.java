package sut.se.team11.entity;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;


@Data
@Entity

public class Assignment {
    @Id
    @SequenceGenerator(name = "assignment_seq", sequenceName = "assignment_seq")
    @GeneratedValue(generator = "assignment_seq", strategy = GenerationType.SEQUENCE)
    private Long assignmentId;
    private String comment;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @OneToOne
    @NonNull
    @JoinColumn(name = "scoreAssignmentId")
    private ScoreAssignment scoreAssignment;

    public Assignment (){

    }

}
