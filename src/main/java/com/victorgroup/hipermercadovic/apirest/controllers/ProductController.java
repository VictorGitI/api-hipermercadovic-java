package com.victorgroup.hipermercadovic.apirest.controllers;

import com.victorgroup.hipermercadovic.apirest.dto.ProductEntityDto;
import com.victorgroup.hipermercadovic.apirest.exceptions.AlreadyExistsException;
import com.victorgroup.hipermercadovic.apirest.exceptions.ResourceNotFoundException;
import com.victorgroup.hipermercadovic.apirest.models.ProductEntity;
import com.victorgroup.hipermercadovic.apirest.request.AddProductRequest;
import com.victorgroup.hipermercadovic.apirest.response.ApiResponse;
import com.victorgroup.hipermercadovic.apirest.services.product.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.HttpStatus.*;
@AllArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<ProductEntity> products = productService.getAllProducts();
        List<ProductEntityDto> convertedProducts = productService.getConvertedProducts(products);
        return ResponseEntity.ok(new ApiResponse("Success", convertedProducts));
    }

    @GetMapping("/product/{productId}/product")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long productId){
        try {
            ProductEntity product = productService.getProductById(productId);
            ProductEntityDto productDto = productService.convertToDto(product);
            return ResponseEntity.ok(new ApiResponse("Success", productDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }

    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product){
        try {
            ProductEntity theProduct = productService.addProduct(product);
            ProductEntityDto productDto = productService.convertToDto(theProduct);
            return ResponseEntity.ok(new ApiResponse("Update Product success", productDto));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }


}
