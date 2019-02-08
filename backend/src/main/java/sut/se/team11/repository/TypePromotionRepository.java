package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.team11.entity.TypePromotion;

@RepositoryRestResource
public interface TypePromotionRepository extends JpaRepository<TypePromotion, Long> {

    TypePromotion findById(long typePromotionId);
}
