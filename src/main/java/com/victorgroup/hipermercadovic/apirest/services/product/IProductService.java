package com.victorgroup.hipermercadovic.apirest.services.product;

import com.victorgroup.hipermercadovic.apirest.dto.ProductDto;
import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import com.victorgroup.hipermercadovic.apirest.request.AddProductRequest;

import java.util.List;

public interface IProductService {

    ProductEntity addProduct(AddProductRequest request);

    ProductDto convertToDto(ProductEntity theProduct);

    List<ProductEntity> getAllProducts();

    List<ProductDto> getConvertedProducts(List<ProductEntity> products);

    ProductEntity getProductById(Long id);
}
