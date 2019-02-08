package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.ReportProblem;

@RepositoryRestResource
public interface ReportProblemRepository extends JpaRepository<ReportProblem, Long>{
    ReportProblem findById(long rpId);
}
