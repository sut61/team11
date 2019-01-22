package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Category {
    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
    @GeneratedValue(generator = "category_seq", strategy = GenerationType.SEQUENCE)
    private Long categoryId;
    private @NonNull String categoryName;
}
