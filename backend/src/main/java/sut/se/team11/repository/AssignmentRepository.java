package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Assignment;

@RepositoryRestResource
public interface AssignmentRepository extends JpaRepository <Assignment,Long> {
    Assignment findById(long assignmentId);
}
