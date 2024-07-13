package com.victorgroup.hipermercadovic.apirest.dao.implementations;

import com.victorgroup.hipermercadovic.apirest.dao.interfaces.IProductDao;
import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImp implements IProductDao {

    @PersistenceContext
    private EntityManager entityManager;
    private IProductDao productDao;

    @Transactional(readOnly = true)
    @Override
    public List<ProductEntity> findAll() {
        String query = "SELECT u FROM ProductEntity u";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductEntity> findById(int id) {
        return Optional.ofNullable(this.entityManager.find(ProductEntity.class, id));
    }

    @Override
    @Transactional
    public void saveProduct(ProductEntity productEntity) {
         this.entityManager.persist(productEntity);
         this.entityManager.flush();
    }

    @Override
    @Transactional
    public void updateProduct(ProductEntity productEntity) {
        this.entityManager.merge(productEntity);
    }

    @Override
    @Transactional
    public void deleteProduct(ProductEntity productEntity) {
        this.entityManager.remove(productEntity);
    }

}
