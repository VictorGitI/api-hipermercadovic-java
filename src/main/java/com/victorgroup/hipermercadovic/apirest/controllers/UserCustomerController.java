package com.victorgroup.hipermercadovic.apirest.controllers;
import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;
import com.victorgroup.hipermercadovic.apirest.dto.UserDTO;
import com.victorgroup.hipermercadovic.apirest.services.interfaces.IUserCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserCustomerController {
    @Autowired
    private IUserCustomerService userService;

    @GetMapping("/user-customer")
    public ResponseEntity<List<UserDTO>>findAll(){
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/user-customer")
    public ResponseEntity<UserDTO>registerUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(this.userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/user-customer/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable int id){
        return new ResponseEntity<>(this.userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }




}
