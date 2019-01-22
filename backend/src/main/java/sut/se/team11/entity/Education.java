package sut.se.team11.entity;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@Entity

public class Education {
    @Id
    @SequenceGenerator(name = "education_seq", sequenceName = "education_seq")
    @GeneratedValue(generator = "education_sq", strategy = GenerationType.SEQUENCE)
    private long edId;
    private String edName;
}
