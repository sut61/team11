package sut.se.team11.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import sut.se.team11.entity.Quotation;

@RepositoryRestResource
public interface QuotationRepository extends JpaRepository<Quotation, Long>  {

    
    Quotation findById(long quotationId);



}
