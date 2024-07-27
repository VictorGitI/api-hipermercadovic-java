package com.victorgroup.hipermercadovic.apirest.models;
import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int userId;
    @Column(name = "nombre_usuario")
    private String userName;
    @Column(name = "contraseña_usuario")
    private String userPassword;
    @Column(name = "rol_usuario_id_rol_usuario")
    private int idRolUsuario;

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
