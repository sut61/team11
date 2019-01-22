package sut.se.team11.entity;

import lombok.*;

import javax.persistence.*;
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
    private Date bDate;
    private String tel;
    private String address;

    @ManyToOne
    @JoinColumn (name = "pId")
    private Province province;

    @ManyToOne
    private Education education;

    @ManyToOne
    private Branch brunch;

    @ManyToOne
    private Position position;  


}