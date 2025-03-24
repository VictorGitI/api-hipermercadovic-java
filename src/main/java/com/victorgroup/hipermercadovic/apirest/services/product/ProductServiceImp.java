package com.victorgroup.hipermercadovic.apirest.services.product;


import com.victorgroup.hipermercadovic.apirest.dto.ProductDto;
import com.victorgroup.hipermercadovic.apirest.exceptions.AlreadyExistsException;
import com.victorgroup.hipermercadovic.apirest.exceptions.ResourceNotFoundException;
import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import com.victorgroup.hipermercadovic.apirest.repository.ProductEntityRepository;
import com.victorgroup.hipermercadovic.apirest.request.AddProductRequest;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements IProductService {

    private final ProductEntityRepository productEntityRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductEntity addProduct(AddProductRequest request) {
        if(productExist(request.getName(), request.getBrand())){
            throw new AlreadyExistsException(request.getBrand() + " " +request.getName() + "already Exist");
        }

        return productEntityRepository.save(createProduct(request));
    }

    @Override
    public ProductDto convertToDto(ProductEntity product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        return productDto;
    }

    private boolean productExist(String name, String brand){
        return productEntityRepository.existsByNameAndBrand(name, brand);
    }
    @Override
    public List<ProductEntity> getAllProducts(){
        return productEntityRepository.findAll();
    }

    @Override
    public List<ProductDto> getConvertedProducts(List<ProductEntity> products) {
        return products.stream().map(this::convertToDto).toList();
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return productEntityRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
    }


    private ProductEntity createProduct(AddProductRequest request){
        return new ProductEntity(
                request.getName(),
                request.getBrand()
        );
    }


}
