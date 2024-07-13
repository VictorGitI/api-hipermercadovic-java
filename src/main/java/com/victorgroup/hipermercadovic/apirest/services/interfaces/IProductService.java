package com.victorgroup.hipermercadovic.apirest.services.interfaces;

import com.victorgroup.hipermercadovic.apirest.dao.interfaces.IProductDao;
import com.victorgroup.hipermercadovic.apirest.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    List<ProductDTO> findAll();

    ProductDTO findById(int id);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO, int id);

    String deleteProduct(int id);
}
