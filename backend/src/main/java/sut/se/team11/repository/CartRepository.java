package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Cart;

@RepositoryRestResource
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findById(long cartId);
}
