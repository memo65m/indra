package com.example.indra.repository;

import com.example.indra.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT p.* FROM PRICE p LEFT JOIN BRAND b ON p.brand_id = b.id LEFT JOIN PRODUCT pro ON p.product_id = pro.id WHERE pro.id = ?1 AND b.id = ?2 AND ?3 >= FORMATDATETIME(start_date, 'dd HH:mm') AND ?3 <= FORMATDATETIME(end_date, 'dd HH:mm') ORDER BY p.priority DESC LIMIT 1", nativeQuery = true)
    Optional<Price> getByDateAndProductAndBrand(Long productId, Long brandId, String date);
}
