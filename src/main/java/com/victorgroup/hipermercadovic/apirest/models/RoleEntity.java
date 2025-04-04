package com.victorgroup.hipermercadovic.apirest.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<UserEntity> users = new HashSet<>();

    public RoleEntity(String name) {
        this.name = name;
    }
}
