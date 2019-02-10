package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Employee {
    @Id @GeneratedValue
    private long eId;
    private String title;
    private String eName;
    @Min(0)
    private int age;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date bDate;
    @NotNull
    @Pattern(regexp = "[0-9]{10}")
    private String tel;
    private String address;

    @ManyToOne
    @JoinColumn (name = "pId")
    private Province province;

    @ManyToOne
    private Education education;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Position position;

}