package sut.se.team11.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.Department;

@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Department findById(long depId);
}
