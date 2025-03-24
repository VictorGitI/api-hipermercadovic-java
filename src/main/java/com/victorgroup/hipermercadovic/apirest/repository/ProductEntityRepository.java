package com.victorgroup.hipermercadovic.apirest.repository;

import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByName(String name);

    List<ProductEntity> findByCategory(String category);

    boolean existsByNameAndBrand(String name, String brand);


}
