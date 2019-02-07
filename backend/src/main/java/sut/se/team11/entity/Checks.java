package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Checks {
    @Id
    @SequenceGenerator(name = "checks_seq", sequenceName = "checks_seq")
    @GeneratedValue(generator = "checks_seq", strategy = GenerationType.SEQUENCE)
    private Long checksId;

    @OneToOne(mappedBy = "checks")
    private UsedItem usedItem;
}
