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
    @Size(min = 20, max = 100)
    @Pattern(regexp = "[^@!#$]+")
    private String rpDetail;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn (name = "ptId")
    private ProblemType problemType;
    @ManyToOne
    @JoinColumn (name = "depId")
    private Department department;
    @ManyToOne
    @JoinColumn (name = "eId")
    private Employee employee;
}
