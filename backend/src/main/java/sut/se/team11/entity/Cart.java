package sut.se.team11.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    private Long cartId;
    private @NonNull String paymentStatus;
    private @NonNull Date date;
}
