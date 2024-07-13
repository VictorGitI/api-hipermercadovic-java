package com.victorgroup.hipermercadovic.apirest.services.implementations;

import com.victorgroup.hipermercadovic.apirest.dao.interfaces.IProductDao;
import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;
import com.victorgroup.hipermercadovic.apirest.dto.UserDTO;
import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import com.victorgroup.hipermercadovic.apirest.services.interfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<ProductDTO> findAll() {

        ModelMapper modelMapper = new ModelMapper();
        return this.productDao.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(int id) {

        Optional<ProductEntity> productEntity = this.productDao.findById(id);

        if(productEntity.isPresent()){

            ModelMapper modelMapper = new ModelMapper();
            ProductEntity currentProduct = productEntity.get();
            return modelMapper.map(currentProduct, ProductDTO.class);
        }
        else {
            return new ProductDTO();
        }
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
            this.productDao.saveProduct(productEntity);

            return productDTO;
        }
        catch (Exception e){
            throw new UnsupportedOperationException("Error al guardar el producto");
        }
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, int id) {
        Optional<ProductEntity> productEntity = this.productDao.findById(id);
        if (productEntity.isPresent()){
            ProductEntity currentProductEntity = productEntity.get();

            currentProductEntity.setProductName(productDTO.getProductName());
            currentProductEntity.setProductDescription(productDTO.getProductDescription());
            currentProductEntity.setPrice(productDTO.getPrice());
            currentProductEntity.setProductStock(productDTO.getProductStock());
            currentProductEntity.setProductBrand(productDTO.getProductBrand());
            currentProductEntity.setProductModel(productDTO.getProductModel());
            currentProductEntity.setProductWeight(productDTO.getProductWeight());
            currentProductEntity.setProductManufacturingDate(productDTO.getProductManufacturingDate());


            productDao.saveProduct(currentProductEntity);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentProductEntity, ProductDTO.class);
        }else {
            throw new IllegalArgumentException("El producto no existe");
        }
    }

    @Override
    public String deleteProduct(int id) {
        Optional<ProductEntity> productEntity = this.productDao.findById(id);
        if(productEntity.isPresent()){
            ProductEntity currentProductEntity = productEntity.get();
            this.productDao.deleteProduct(currentProductEntity);
            return "Usuario con ID "+ id + " ha sido eliminado";
        }else {
            return "El usuario con ID "+ id +"no existe";
        }

    }
}
