package com.victorgroup.hipermercadovic.apirest.services.user;

import com.victorgroup.hipermercadovic.apirest.dto.UserEntityDto;
import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import com.victorgroup.hipermercadovic.apirest.request.CreateUserRequest;
import com.victorgroup.hipermercadovic.apirest.request.UserUpdateRequest;

public interface IUserService {
    UserEntity getUserById(Long id);
    UserEntityDto convertUserToDto(UserEntity user);
    UserEntity createUser(CreateUserRequest request);
    UserEntity updateUserEntity(UserUpdateRequest request, Long id);
    void deleteUser(Long id);

}
