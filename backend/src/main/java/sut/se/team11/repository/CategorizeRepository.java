package sut.se.team11.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Categorize;

@RepositoryRestResource
public interface CategorizeRepository extends JpaRepository<Categorize, Long> {
    Categorize findById(long categorizeId);
}
