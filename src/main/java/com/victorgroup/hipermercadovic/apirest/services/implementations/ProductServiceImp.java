package com.victorgroup.hipermercadovic.apirest.services.implementations;

import com.victorgroup.hipermercadovic.apirest.dao.interfaces.IProductDao;
import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;
import com.victorgroup.hipermercadovic.apirest.services.interfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }
}
