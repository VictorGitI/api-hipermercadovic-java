package com.victorgroup.hipermercadovic.apirest.services.implementations;

import com.victorgroup.hipermercadovic.apirest.dao.interfaces.IUserDao;
import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;
import com.victorgroup.hipermercadovic.apirest.dto.UserDTO;
import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import com.victorgroup.hipermercadovic.apirest.services.interfaces.IUserCustomerService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserCustomerServiceImp implements IUserCustomerService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String hash = argon2.hash(1, 1024,1, userDTO.getUserPassword());

        userDTO.setUserPassword(hash);

        try{
            ModelMapper modelMapper = new ModelMapper();
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            userEntity.setIdRolUsuario(1);
            this.userDao.registerUser(userEntity);

            return userDTO;
        }
        catch (Exception e){
            throw new UnsupportedOperationException("Error al registrar el usuario");
        }
    }

    @Override
    public String deleteUser(int id) {
        Optional<UserEntity> userEntity = this.userDao.findById(id);
        if(userEntity.isPresent()){
            UserEntity currentUserEntity = userEntity.get();
            this.userDao.deleteUser(currentUserEntity);
            return "Usuario con ID "+ id + " ha sido eliminado";
        }else {
            return "El usuario con ID "+ id +"no existe";
        }

    }

    @Override
    public List<UserDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.userDao.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }
}
