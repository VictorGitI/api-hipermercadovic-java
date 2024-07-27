package com.victorgroup.hipermercadovic.apirest.dao.implementations;

import com.victorgroup.hipermercadovic.apirest.dao.interfaces.IUserDao;
import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;
import com.victorgroup.hipermercadovic.apirest.dto.UserDTO;
import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImp implements IUserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findById(int id) {
        return Optional.ofNullable(this.entityManager.find(UserEntity.class, id));
    }

    @Override
    @Transactional
    public void registerUser(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Override
    @Transactional
    public void deleteUser(UserEntity userEntity) {
        entityManager.remove(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        String query = "SELECT u FROM UserEntity u";
        return entityManager.createQuery(query).getResultList();
    }

}
