package com.victorgroup.hipermercadovic.apirest.repository;

import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

    UserEntity findByEmail(String email); 
}
