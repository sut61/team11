package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.BuyItem;

@RepositoryRestResource
public interface BuyItemRepository extends JpaRepository<BuyItem, Long> {
     BuyItem findById(long buyItemId);
}
