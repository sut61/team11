package sut.se.team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sut.se.team11.entity.SavePrice;

public interface SavePriceRepository extends JpaRepository<SavePrice, Long> {
    SavePrice findById(long priceTagId);

}
