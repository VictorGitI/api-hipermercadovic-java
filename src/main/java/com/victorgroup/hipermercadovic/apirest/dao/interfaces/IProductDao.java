package com.victorgroup.hipermercadovic.apirest.dao.interfaces;

import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import com.victorgroup.hipermercadovic.apirest.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IProductDao {
    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(int id);

    void saveProduct(ProductEntity productEntity);

    void updateProduct(ProductEntity productEntity);

    void deleteProduct(ProductEntity productEntity);
}
