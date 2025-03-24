package com.victorgroup.hipermercadovic.apirest.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity*/
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userPassword;
    private int idRolUser;

}
