package com.victorgroup.hipermercadovic.apirest.dao.interfaces;

import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;
import com.victorgroup.hipermercadovic.apirest.dto.UserDTO;
import com.victorgroup.hipermercadovic.apirest.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDao {

    Optional<UserEntity>findById(int id);

    void registerUser(UserEntity userEntity);

    void deleteUser(UserEntity userEntity);

    List<UserEntity> findAll();
}
