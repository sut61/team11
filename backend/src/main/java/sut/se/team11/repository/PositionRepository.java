package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Position;

@RepositoryRestResource
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findById(long psId);
}
