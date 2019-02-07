package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Repairman;

@RepositoryRestResource
public interface RepairmanRepository extends JpaRepository<Repairman, Long> {
    Repairman findById(long repairmanId);
}
