package sut.se.team11.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import sut.se.team11.entity.ProblemType;

@RepositoryRestResource
public interface ProblemTypeRepository extends JpaRepository<ProblemType, Long>{
    ProblemType findById(long ptId);

}
