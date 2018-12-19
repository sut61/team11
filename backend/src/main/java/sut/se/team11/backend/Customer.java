package sut.se.team11.backend;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id @GeneratedValue 
    private @NonNull Long id;
    private @NonNull String name;
}
