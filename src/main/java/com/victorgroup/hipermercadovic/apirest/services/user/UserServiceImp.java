package com.victorgroup.hipermercadovic.apirest.services.user;


import com.victorgroup.hipermercadovic.apirest.dto.UserEntityDto;
import com.victorgroup.hipermercadovic.apirest.exceptions.AlreadyExistsException;
import com.victorgroup.hipermercadovic.apirest.exceptions.ResourceNotFoundException;
import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import com.victorgroup.hipermercadovic.apirest.repository.UserEntityRepository;
import com.victorgroup.hipermercadovic.apirest.request.CreateUserRequest;
import com.victorgroup.hipermercadovic.apirest.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements IUserService {
    private final UserEntityRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserEntityDto convertUserToDto(UserEntity user) {
        return modelMapper.map(user, UserEntityDto.class);
    }

    @Override
    public UserEntity createUser(CreateUserRequest request) {
        return  Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(user.getEmail()))
                .map(req -> {
                    UserEntity userEntity = new UserEntity();
                    userEntity.setEmail(req.getEmail());
                    userEntity.setPassword(passwordEncoder.encode(req.getPassword()));
                    userEntity.setFirstName(req.getFirstName());
                    userEntity.setLastName(req.getLastName());
                    return userRepository.save(userEntity);
                }) .orElseThrow(() -> new AlreadyExistsException("Oops!" +request.getEmail() +" already exists!"));
    }

    @Override
    public UserEntity updateUserEntity(UserUpdateRequest request, Long id) {
        return userRepository.findById(id).map(existingUser ->{
            existingUser.setFirstName(request.getFirstName());
            existingUser.setLastName(request.getLastName());
            return userRepository.save(existingUser);
        }).orElseThrow(()-> new ResourceNotFoundException("User Not found"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresentOrElse(userRepository::delete, () ->{
            throw new ResourceNotFoundException("User not found");
        });
    }


}
