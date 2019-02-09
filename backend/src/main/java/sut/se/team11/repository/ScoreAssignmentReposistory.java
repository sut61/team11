package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sut.se.team11.entity.ScoreAssignment;

public interface ScoreAssignmentReposistory extends JpaRepository <ScoreAssignment,Long> {
    ScoreAssignment findById(long scoreAssignmentId);
}
