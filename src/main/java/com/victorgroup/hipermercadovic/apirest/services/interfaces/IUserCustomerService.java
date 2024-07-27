package com.victorgroup.hipermercadovic.apirest.services.interfaces;

import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;
import com.victorgroup.hipermercadovic.apirest.dto.UserDTO;

import java.util.List;

public interface IUserCustomerService {

    UserDTO createUser(UserDTO userDTO);

    String deleteUser(int id);

    List<UserDTO> findAll();
}
