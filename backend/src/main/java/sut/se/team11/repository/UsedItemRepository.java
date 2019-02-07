package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.UsedItem;

@RepositoryRestResource
public interface UsedItemRepository extends JpaRepository<UsedItem, Long> {
    UsedItem findById(long usedItemId);
}
