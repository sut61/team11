package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Career;

@RepositoryRestResource
public interface CareerRepository extends JpaRepository<Career, Long> {
    Career findById(long cId);
}
