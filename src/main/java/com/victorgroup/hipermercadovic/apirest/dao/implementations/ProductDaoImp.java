package com.victorgroup.hipermercadovic.apirest.dao.implementations;

import com.victorgroup.hipermercadovic.apirest.dao.interfaces.IProductDao;
import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductDaoImp implements IProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<ProductEntity> findAll() {
        String query = "SELECT u FROM ProductEntity u";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Optional<ProductEntity> findById(int id) {
        return Optional.empty();
    }

    @Override
    public ProductEntity saveProduct(UserEntity userEntity) {
        return null;
    }
}
