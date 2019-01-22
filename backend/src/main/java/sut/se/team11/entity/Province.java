package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor


public class Province {
    @Id
    @SequenceGenerator(name = "province_seq", sequenceName = "province_seq")
    @GeneratedValue(generator = "province_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long pId;
    private @NonNull String pName;

}
