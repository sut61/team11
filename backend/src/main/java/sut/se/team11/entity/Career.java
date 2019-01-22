package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor


public class Career {
    @Id
    @SequenceGenerator(name = "career_seq", sequenceName = "career_seq")
    @GeneratedValue(generator = "career_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long cId;
    private @NonNull String cName;
}
