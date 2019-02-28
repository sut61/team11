package sut.se.team11.entity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class ReportProblem {
    @Id
    @SequenceGenerator(name = "report_problem_seq", sequenceName = "report_problem_seq")
    @GeneratedValue(generator = "report_problem_seq", strategy = GenerationType.SEQUENCE)
    private Long rpId;

    @NotNull
    @Size(min = 10, max = 100)
    @Pattern(regexp = "[^@!#$%&*]+")
    private String rpDetail;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date date;

    @NotNull
    @ManyToOne
    @JoinColumn (name = "ptId")
    private ProblemType problemType;

    @NotNull
    @ManyToOne
    @JoinColumn (name = "depId")
    private Department department;

    @NotNull
    @ManyToOne
    @JoinColumn (name = "eId")
    private Employee employee;
}
