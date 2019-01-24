package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private int age;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull
    private Date bDate;
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