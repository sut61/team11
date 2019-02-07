package sut.se.team11.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Categorize {
    @Id
    @SequenceGenerator(name = "categorize_seq", sequenceName = "categorize_seq")
    @GeneratedValue(generator = "categorize_seq", strategy = GenerationType.SEQUENCE)
    private Long categorizeId;
    private @NotNull String categorizeName;
}
