package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Unit;

@RepositoryRestResource
public interface UnitRepository extends JpaRepository<Unit, Long> {
    Unit findById(long unitId);
}
