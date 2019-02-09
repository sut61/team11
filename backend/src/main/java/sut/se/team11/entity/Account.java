package sut.se.team11.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Long accId;

    private @NonNull  String username;
    @JsonIgnore
    private @NonNull  String password;
    private boolean isLogin;

    @OneToOne
    private Employee employee;

}
