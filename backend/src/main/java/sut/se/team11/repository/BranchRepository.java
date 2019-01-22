package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Branch;

@RepositoryRestResource
public interface BranchRepository extends JpaRepository<Branch, Long> {
    Branch findById(long bId);
}