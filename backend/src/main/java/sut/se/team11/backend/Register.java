package sut.se.team11.backend;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;

@Data
@Entity
public class Register {

    @Id
    @SequenceGenerator(name = "register_seq", sequenceName = "register_seq")
    @GeneratedValue(generator = "register_seq", strategy = GenerationType.SEQUENCE)
    private Long reId;



    public Register(){}


}
