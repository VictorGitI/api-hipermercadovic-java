package com.victorgroup.hipermercadovic.apirest.dto;

import jakarta.persistence.Column;

public class UserDTO {

    private int userId;
    private String userName;
    private String userPassword;
    private int idRolUsuario;

    public UserDTO() {
    }

    public UserDTO(int userId, String userName, String userPassword, int idRolUsuario) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.idRolUsuario = idRolUsuario;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(int idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }
}
