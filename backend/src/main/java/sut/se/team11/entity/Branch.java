package sut.se.team11.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor


public class Branch {
    @Id
    @SequenceGenerator(name = "branch_seq", sequenceName = "branch_seq")
    @GeneratedValue(generator = "branch_seq", strategy = GenerationType.SEQUENCE)
    private @NotNull Long bId;
    private @NotNull String bName;


}
