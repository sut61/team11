package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Positive
    @Min(16)
    @Max(60)
    private int age;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date bDate;
    @NotNull
    @Pattern(regexp = "[0-9]{10}")
    private String tel;
    @NotNull
    @Size(min=3,max=30)
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